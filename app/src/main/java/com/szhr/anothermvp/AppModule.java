package com.szhr.anothermvp;

import android.content.Context;
import android.content.res.Resources;

import com.github.jupittar.commlib.utilities.NetworkUtils;
import com.szhr.anothermvp.core.util.LoggerHelper;
import com.szhr.anothermvp.core.util.NetworkHelper;
import com.szhr.anothermvp.core.util.SchedulerProvider;
import com.szhr.anothermvp.core.data.entity.Configuration;
import com.szhr.anothermvp.util.AppNetworkHelper;
import com.szhr.anothermvp.util.AppSchedulerProvider;
import com.szhr.anothermvp.util.AppLoggerHelper;
import com.szhr.anothermvp.util.SharedPreferencesManager;
import com.szhr.anothermvp.util.TmdbApiConfigurationUtils;

import java.io.File;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
@SuppressWarnings("unused")
public class AppModule {

  private TmdbApp mApp;

  AppModule(TmdbApp app) {
    this.mApp = app;
  }

  @Provides
  @Singleton
  LoggerHelper provideLoggerHelper(Context context) {
    return new AppLoggerHelper(context);
  }

  @Provides
  @Singleton
  @Named("secureBaseUrl")
  String provideSecureBaseUrl(Context context) {
    return TmdbApiConfigurationUtils.getSecureBaseUrl(context);
  }

  @Provides
  @Singleton
  @Named("posterSize")
  String providePosterSize(Context context) {
    return TmdbApiConfigurationUtils.getPosterSize(context);
  }

  @Provides
  @Singleton
  @Named("isApiConfigurationExisted")
  boolean isApiConfigurationExisted(Context context) {
    Configuration configuration = SharedPreferencesManager.getConfiguration(context);
    return configuration != null;
  }

  @Provides
  @Singleton
  SchedulerProvider provideAppScheduler() {
    return new AppSchedulerProvider();
  }

  @Provides
  @Singleton
  @Named("cacheDir")
  File provideCacheDir(Context context) {
    return context.getCacheDir();
  }

  @Provides
  @Singleton
  NetworkHelper provideNetworkHelper(Context context) {
    return new AppNetworkHelper(context);
  }

  @Provides
  @Singleton
  @Named("isDebug")
  boolean isDebug() {
    return BuildConfig.DEBUG;
  }

  @Provides
  @Singleton
  Context provideContext() {
    return mApp.getApplicationContext();
  }

  @Provides
  @Singleton
  Resources provideResource() {
    return mApp.getResources();
  }

}
