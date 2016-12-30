package com.szhr.anothermvp.core.ui.movie.popular;

import com.szhr.anothermvp.core.ui.base.Mvp;

import dagger.Module;
import dagger.Provides;

@Module
@SuppressWarnings("unused")
public class PopularMoviesModule {

  private PopularMoviesMvp.View mView;

  public PopularMoviesModule(PopularMoviesMvp.View view) {
    mView = view;
  }

  @Provides
  public PopularMoviesMvp.View provideView() {
    return mView;
  }

  @Provides
  @PopularMoviesScope
  public PopularMoviesMvp.Presenter<PopularMoviesMvp.View> providePresenter(
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
