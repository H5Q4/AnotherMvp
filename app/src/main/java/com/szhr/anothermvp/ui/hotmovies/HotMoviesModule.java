package com.szhr.anothermvp.ui.hotmovies;

import com.szhr.anothermvp.core.ui.hotmovies.HotMoviesView;

import dagger.Module;

/**
 * Provide HotMoviesView and HotMoviesPresenter for hot movies
 */

@Module
class HotMoviesModule {

  private HotMoviesView mView;

  public HotMoviesModule(HotMoviesView view) {
    mView = view;
  }

}
