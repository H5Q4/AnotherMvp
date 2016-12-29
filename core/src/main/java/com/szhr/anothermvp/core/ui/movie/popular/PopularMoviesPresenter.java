package com.szhr.anothermvp.core.ui.movie.popular;

import com.szhr.anothermvp.core.SchedulerProvider;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Subscription;

public class PopularMoviesPresenter extends PopularMoviesMvp.Presenter<PopularMoviesView> {

  @Inject
  PopularMoviesInteractor mInteractor;
  @Inject
  @Named("isApiConfigurationExisted")
  boolean mIsApiConfigurationExisted;

  private SchedulerProvider mSchedulerProvider;

  @Inject
  public PopularMoviesPresenter(SchedulerProvider schedulerProvider) {
    mSchedulerProvider = schedulerProvider;
  }

  @Override
  void showPopularMovies(int page) {
    if (!mIsApiConfigurationExisted) {
      mInteractor
          .loadApiConfiguration()
          .observeOn(mSchedulerProvider.mainThread())
          .subscribe(configuration -> handlePopularMovies(page));
    } else {
      handlePopularMovies(page);
    }
  }

  private Subscription handlePopularMovies(int page) {
    return mInteractor
        .loadMovies(page)
        .observeOn(mSchedulerProvider.mainThread())
        .subscribe(movies -> {});
  }
}
