package com.szhr.anothermvp.core.util;

import com.szhr.anothermvp.core.data.entity.Configuration;

public interface AndroidHelper {

  void saveApiConfiguration(Configuration configuration);

  boolean isApiConfigurationExisted();

  boolean isNetworkConnected();

}
