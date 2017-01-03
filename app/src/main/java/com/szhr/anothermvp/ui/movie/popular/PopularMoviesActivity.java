package com.szhr.anothermvp.ui.movie.popular;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.szhr.anothermvp.AppComponent;
import com.szhr.anothermvp.R;
import com.szhr.anothermvp.ui.base.BaseActivity;

import butterknife.BindView;

public class PopularMoviesActivity
    extends BaseActivity
    implements PopularMoviesFragment.OnFragmentInteractionListener {

  private static final String TAG_FRAGMENT_POPULAR_MOVIES = "PopularMoviesFragment";

  @BindView(R.id.toolbar)
  Toolbar mToolbar;

  private PopularMoviesFragment mPopularMoviesFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    setUpToolbar();
    if (savedInstanceState != null) {
      mPopularMoviesFragment = (PopularMoviesFragment) getSupportFragmentManager()
          .findFragmentByTag(TAG_FRAGMENT_POPULAR_MOVIES);
    } else {
      mPopularMoviesFragment = PopularMoviesFragment.newInstance();
      getSupportFragmentManager()
          .beginTransaction()
          .replace(R.id.fl_content, mPopularMoviesFragment, TAG_FRAGMENT_POPULAR_MOVIES)
          .commit();
    }
  }

  private void setUpToolbar() {
    setSupportActionBar(mToolbar);
    getSupportActionBar().setTitle("TMDb");
  }

  @Override
  protected void injectDependencies(AppComponent component) {
    component.inject(this);
  }
}
