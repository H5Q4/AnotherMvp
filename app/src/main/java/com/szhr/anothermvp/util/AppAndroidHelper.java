package com.szhr.anothermvp.util;

import android.content.Context;

import com.github.jupittar.commlib.utilities.NetworkUtils;
import com.szhr.anothermvp.core.data.entity.Configuration;
import com.szhr.anothermvp.core.util.AndroidHelper;

@SuppressWarnings("unused")
public class AppAndroidHelper implements AndroidHelper {

  private Context mContext;

  public AppAndroidHelper(Context context) {
    mContext = context;
  }

  @Override
  public void saveApiConfiguration(Configuration configuration) {
    SharedPreferencesManager.setConfiguration(mContext, configuration);
  }

  public boolean isApiConfigurationExisted() {
    Configuration configuration = SharedPreferencesManager.getConfiguration(mContext);
    return configuration != null;
  }

  @Override
  public boolean isNetworkConnected() {
    return NetworkUtils.isNetworkConnected(mContext);
  }
}
