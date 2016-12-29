package com.szhr.anothermvp;

import android.content.Context;
import android.content.res.Resources;

import com.github.jupittar.commlib.utilities.NetworkUtils;
import com.szhr.anothermvp.core.SchedulerProvider;
import com.szhr.anothermvp.core.data.entity.Configuration;
import com.szhr.anothermvp.util.SharedPreferencesManager;

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
  @Named("isNetworkConnected")
  boolean isNetworkConnected(Context context) {
    return NetworkUtils.isNetworkConnected(context);
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
