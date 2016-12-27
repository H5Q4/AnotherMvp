package com.szhr.anothermvp;

import android.content.Context;
import android.content.res.Resources;

import com.github.jupittar.commlib.utilities.NetworkUtils;

import java.io.File;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

  private VmovierApp mApp;

  AppModule(VmovierApp app) {
    this.mApp = app;
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
