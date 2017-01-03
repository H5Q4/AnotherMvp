package com.szhr.anothermvp.ui.movie.detail;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.szhr.anothermvp.AppComponent;
import com.szhr.anothermvp.R;
import com.szhr.anothermvp.ui.base.BaseActivity;

public class MovieDetailActivity extends BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_movie_detail);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
  }

  @Override
  protected void injectDependencies(AppComponent component) {

  }

}
