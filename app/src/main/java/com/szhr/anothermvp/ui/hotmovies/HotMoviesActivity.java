package com.szhr.anothermvp.ui.hotmovies;

import android.os.Bundle;

import com.szhr.anothermvp.AppComponent;
import com.szhr.anothermvp.R;
import com.szhr.anothermvp.ui.base.BaseAppCompactActivity;

public class HotMoviesActivity extends BaseAppCompactActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  @Override
  protected void injectDependencies(AppComponent component) {
    component.inject(this);
  }
}
