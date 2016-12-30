package com.szhr.anothermvp.util;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.szhr.anothermvp.core.util.LoggerHelper;

@SuppressWarnings("unused")
public class AppLoggerHelper implements LoggerHelper {

  private Context mContext;

  public AppLoggerHelper(Context context) {
    mContext = context;
  }

  @Override
  public void t(int methodCount) {
     Logger.t(methodCount);
  }

  @Override
  public void i(String message, Object... args) {
    Logger.i(message, args);
  }

  @Override
  public void v(String message, Object... args) {
    Logger.v(message, args);
  }

  @Override
  public void d(String message, Object... args) {
    Logger.d(message, args);
  }

  @Override
  public void e(String message, Object... args) {
    Logger.e(message, args);
  }

  @Override
  public void e(Throwable throwable, String message, Object... args) {
    Logger.e(throwable, message, args);
  }

  @Override
  public void json(String json) {
    Logger.json(json);
  }

}
