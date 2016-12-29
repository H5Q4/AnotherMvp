package com.szhr.anothermvp.ui.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import com.szhr.anothermvp.AppComponent;
import com.szhr.anothermvp.TmdbApp;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

  private Unbinder mUnbinder;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    injectDependencies(TmdbApp.getAppComponent());
  }

  @Override
  public void setContentView(@LayoutRes int layoutResID) {
    super.setContentView(layoutResID);
    mUnbinder = ButterKnife.bind(this);
  }

  @Override
  protected void onDestroy() {
    mUnbinder.unbind();
    super.onDestroy();
  }

  protected abstract void injectDependencies(AppComponent component);

}
