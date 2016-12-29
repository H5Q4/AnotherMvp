package com.szhr.anothermvp.core.data.remote;

import com.google.gson.Gson;
import com.szhr.anothermvp.core.util.Constants;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@SuppressWarnings("unused")
public class NetworkModule {

  @Provides
  @Singleton
  public TmdbService provideTmdbService(Retrofit retrofit) {
    return retrofit.create(TmdbService.class);
  }

  //region Retrofit
  @Provides
  @Singleton
  public Retrofit provideRetrofit(
      GsonConverterFactory converterFactory,
      RxJavaCallAdapterFactory callAdapterFactory,
      OkHttpClient okHttpClient
      ) {
    return new Retrofit
        .Builder()
        .baseUrl(Constants.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(converterFactory)
        .addCallAdapterFactory(callAdapterFactory)
        .build();
  }

  @Provides
  @Singleton
  public GsonConverterFactory provideGsonConverterFactory(Gson gson) {
    return GsonConverterFactory.create(gson);
  }

  @Provides
  @Singleton
  public Gson provideGson() {
    return new Gson();
  }

  @Provides
  @Singleton
  public RxJavaCallAdapterFactory provideRxjavaCallAdapterFactory() {
    return RxJavaCallAdapterFactory.create();
  }
  //endregion

  //region OkHttpClient
  @Provides
  @Singleton
  public OkHttpClient provideOkHttpClient(
      @Named("isDebug") boolean isDebug,
      Cache cache,
      HttpLoggingInterceptor loggingInterceptor,
      @Named("authInterceptor") Interceptor authInterceptor,
      @Named("cacheInterceptor") Interceptor cacheInterceptor,
      @Named("offlineCacheInterceptor") Interceptor offlineInterceptor
      ) {
    OkHttpClient.Builder builder = new OkHttpClient.Builder()
        .connectTimeout(Constants.NETWORK_CONNECTION_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(Constants.NETWORK_READ_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(Constants.NETWORK_WRITE_TIMEOUT, TimeUnit.SECONDS)
        .addNetworkInterceptor(cacheInterceptor)
        .addInterceptor(offlineInterceptor)
        .cache(cache);

    if (isDebug) {
      builder.addInterceptor(loggingInterceptor);
    }

    return builder.build();
  }

  @Provides
  @Singleton
  public Cache provideCache(
      @Named("cacheDir") File cacheDir
      ) {
    Cache cache = null;
    try {
      cache = new Cache(new File(cacheDir.getPath(), "http"), Constants.CACHE_SIZE);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return cache;
  }

  @Provides
  @Singleton
  public HttpLoggingInterceptor provideHttpLoggingInterceptor() {
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    return interceptor;
  }

  @Provides
  @Singleton
  @Named("authInterceptor")
  public Interceptor provideAuthInterceptor() {
    return chain -> {
      Request request = chain.request();
      HttpUrl url = request.url();
      HttpUrl newUrl = url.newBuilder()
          .addQueryParameter("api_key", Constants.API_KEY)
          .addQueryParameter("language", "en-US")
          .build();
      Request newRequest = request.newBuilder()
          .url(newUrl)
          .build();

      return chain.proceed(newRequest);
    };
  }

  @Provides
  @Singleton
  @Named("cacheInterceptor")
  public Interceptor provideCacheInterceptor() {
    return chain -> {
      Response response = chain.proceed(chain.request());
      CacheControl cacheControl = new CacheControl.Builder()
          .maxAge(Constants.CACHE_MAX_AGE_MINS, TimeUnit.MINUTES)
          .build();
      return response.newBuilder()
          .removeHeader("Pragma")
          .header("Cache-Control", cacheControl.toString())
          .build();
    };
  }

  @Provides
  @Singleton
  @Named("offlineCacheInterceptor")
  public Interceptor provideOfflineCacheInterceptor(
      @Named("isNetworkConnected") boolean isNetworkConnected
  ) {
    return chain -> {
      Request request = chain.request();

      if (!isNetworkConnected) {
        CacheControl cacheControl = new CacheControl.Builder()
            .maxStale(Constants.CACHE_MAX_STALE_DAYS, TimeUnit.DAYS)
            .build();
        request = request.newBuilder()
            .cacheControl(cacheControl)
            .build();
      }

      return chain.proceed(request);
    };
  }

  @Provides
  @Singleton
  @Named("retryInterceptor")
  public Interceptor provideRetryInterceptor() {
    return chain -> {
      Request request = chain.request();
      Response response = null;
      IOException exception = null;

      int tryCount = 0;
      while (tryCount < Constants.RETRY_COUNT && (null == response || !response.isSuccessful())) {
        // retry the request
        try {
          response = chain.proceed(request);
        } catch (IOException e) {
          exception = e;
        } finally {
          tryCount++;
        }
      }

      // throw last exception
      if (null == response && null != exception)
        throw exception;

      // otherwise just pass the original response on
      return response;
    };
  }
  //endregion

}
