package com.szhr.anothermvp.ui.hotmovies;

import com.szhr.anothermvp.core.ui.hotmovies.HotMoviesPresenter;
import com.szhr.anothermvp.core.ui.hotmovies.HotMoviesView;

import dagger.Module;
import dagger.Provides;

/**
 * Provide HotMoviesView and HotMoviesPresenter for hot movies
 */

@Module
class HotMoviesModule {

  private HotMoviesView mView;

  public HotMoviesModule(HotMoviesView view) {
    mView = view;
  }

  @Provides
  public HotMoviesView provideView() {
    return mView;
  }

  public HotMoviesPresenter providePresenter(HotMoviesPresenter presenter) {
    presenter.attach(mView);
    return presenter;
  }

}
