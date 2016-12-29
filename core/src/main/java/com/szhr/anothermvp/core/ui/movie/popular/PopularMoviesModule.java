package com.szhr.anothermvp.core.ui.movie.popular;

import com.szhr.anothermvp.core.ui.base.Mvp;

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
  @PopularMoviesScope
  public PopularMoviesMvp.Presenter<PopularMoviesView> providePresenter(
      PopularMoviesPresenter presenter) {
    presenter.attach(mView);
    return presenter;
  }

  @Provides
  @PopularMoviesScope
  public PopularMoviesMvp.Interactor provideInteractor(PopularMoviesInteractor interactor) {
    return interactor;
  }

}
