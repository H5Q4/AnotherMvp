package com.szhr.anothermvp.core.ui.movie.detail;

import dagger.Module;
import dagger.Provides;

@Module
@SuppressWarnings("unused")
public class MovieDetailModule {

  private MovieDetailMvp.View mView;

  public MovieDetailModule(MovieDetailMvp.View view) {
    mView = view;
  }

  @Provides
  public MovieDetailMvp.View provideView() {
    return mView;
  }

  @Provides
  @MovieDetailScope
  public MovieDetailMvp.Presenter<MovieDetailMvp.View> providePresenter(
      MovieDetailPresenter presenter) {
    presenter.attach(mView);
    return presenter;
  }

  @Provides
  @MovieDetailScope
  public MovieDetailMvp.Interactor provideInteractor(MovieDetailInteractor interactor) {
    return interactor;
  }

}
