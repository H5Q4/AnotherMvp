package com.szhr.anothermvp;

import android.app.Application;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.szhr.anothermvp.core.data.remote.NetworkModule;
import com.szhr.anothermvp.core.util.Constants;

public class TmdbApp extends Application {

  private static final String LOGGER_TAG = "VMOVIERLOG";

  private static AppComponent sAppComponent;

  public static AppComponent getAppComponent() {
    return sAppComponent;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    if (BuildConfig.DEBUG) {
      initApp4Debug();
    } else {
      initApp4Release();
    }
    sAppComponent = createAppComponent();
  }

  private AppComponent createAppComponent() {
    return DaggerAppComponent
        .builder()
        .appModule(new AppModule(this))
        .networkModule(new NetworkModule())
        .build();
  }

  private void initApp4Release() {
    Logger
        .init()
        .logLevel(LogLevel.NONE);
  }

  private void initApp4Debug() {
    Logger
        .init(LOGGER_TAG)
        .methodCount(3)                 // default 2
        .logLevel(LogLevel.FULL)        // default LogLevel.FULL
        .hideThreadInfo()
        .methodOffset(2);                // default 0
  }

}
