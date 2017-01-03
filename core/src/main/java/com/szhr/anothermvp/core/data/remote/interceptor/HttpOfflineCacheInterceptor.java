package com.szhr.anothermvp.core.data.remote.interceptor;

import com.szhr.anothermvp.core.util.Constants;
import com.szhr.anothermvp.core.util.NetworkHelper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@SuppressWarnings("unused")
public class HttpOfflineCacheInterceptor implements Interceptor {

  private NetworkHelper mNetworkHelper;

  public HttpOfflineCacheInterceptor(NetworkHelper networkHelper) {
    mNetworkHelper = networkHelper;
  }

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request request = chain.request();

    if (!mNetworkHelper.isConnected()) {
      CacheControl cacheControl = new CacheControl.Builder()
          .maxStale(Constants.CACHE_MAX_STALE_DAYS, TimeUnit.DAYS)
          .build();
      request = request.newBuilder()
          .cacheControl(cacheControl)
          // if your server doesn't support cache header, uncomment below to replace the upper line
          // may work(not tested!)
//          .header("Cache-Control", "public, only-if-cached, max-stale="
//              + Constants.CACHE_MAX_STALE_DAYS * 24 * 60 * 60)
          .build();
      System.out.println("No Network, Read From Cache");
    }

    return chain.proceed(request);
  }
}
