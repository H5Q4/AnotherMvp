package com.szhr.anothermvp;

import android.content.Context;
import android.content.res.Resources;

import com.szhr.anothermvp.core.util.AndroidHelper;
import com.szhr.anothermvp.core.util.LoggerHelper;
import com.szhr.anothermvp.core.util.SchedulerProvider;
import com.szhr.anothermvp.core.data.entity.Configuration;
import com.szhr.anothermvp.util.AppAndroidHelper;
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
  LoggerHelper provideLoggerHelper() {
    return new AppLoggerHelper();
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
  AndroidHelper provideAndroidHelper(Context context) {
    return new AppAndroidHelper(context);
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
