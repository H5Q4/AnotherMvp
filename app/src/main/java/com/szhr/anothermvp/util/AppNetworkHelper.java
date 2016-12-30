package com.szhr.anothermvp.util;

import android.content.Context;

import com.github.jupittar.commlib.utilities.NetworkUtils;
import com.szhr.anothermvp.core.util.NetworkHelper;

@SuppressWarnings("unused")
public class AppNetworkHelper implements NetworkHelper {

  private Context mContext;

  public AppNetworkHelper(Context context) {
    mContext = context;
  }

  @Override
  public boolean isConnected() {
    return NetworkUtils.isNetworkConnected(mContext);
  }
}
