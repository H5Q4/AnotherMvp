package com.szhr.anothermvp.ui.popular_movies;

import com.szhr.anothermvp.core.ui.popular_movies.PopularMoviesPresenter;
import com.szhr.anothermvp.core.ui.popular_movies.PopularMoviesView;

import dagger.Module;
import dagger.Provides;

@Module
@SuppressWarnings("unused")
public class PopularMoviesModule {

  private PopularMoviesView mView;

  public PopularMoviesModule(PopularMoviesView view) {
    mView = view;
  }

  @Provides
  public PopularMoviesView provideView() {
    return mView;
  }

  @Provides
  public PopularMoviesPresenter providePresenter(PopularMoviesPresenter presenter) {
    presenter.attach(mView);
    return presenter;
  }

}
