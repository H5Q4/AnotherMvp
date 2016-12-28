package com.szhr.anothermvp.ui.base;

import android.os.Bundle;

import com.github.jupittar.commlib.base.BaseActivity;
import com.szhr.anothermvp.AppComponent;
import com.szhr.anothermvp.TmdbApp;

public abstract class BaseAppCompactActivity extends BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    injectDependencies(TmdbApp.getAppComponent());
  }

  protected abstract void injectDependencies(AppComponent component);

}
