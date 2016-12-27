package com.szhr.anothermvp.ui.base;

import android.os.Bundle;

import com.github.jupittar.commlib.base.BaseActivity;
import com.szhr.anothermvp.AppComponent;
import com.szhr.anothermvp.VmovierApp;

public abstract class BaseAppCompactActivity extends BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    injectDependencies(VmovierApp.getAppComponent());
  }

  protected abstract void injectDependencies(AppComponent component);

}
