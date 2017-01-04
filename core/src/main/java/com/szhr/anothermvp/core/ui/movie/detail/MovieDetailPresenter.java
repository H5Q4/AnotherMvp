package com.szhr.anothermvp.core.ui.movie.detail;

import com.szhr.anothermvp.core.util.AndroidHelper;
import com.szhr.anothermvp.core.util.SchedulerProvider;

import javax.inject.Inject;

import rx.Subscription;

public class MovieDetailPresenter extends MovieDetailMvp.Presenter<MovieDetailMvp.View> {

  @Inject
  MovieDetailInteractor mInteractor;
  @Inject
  AndroidHelper mAndroidHelper;

  private SchedulerProvider mSchedulerProvider;

  @Inject
  public MovieDetailPresenter(SchedulerProvider schedulerProvider) {
    mSchedulerProvider = schedulerProvider;
  }

  @Override
  void showMovieDetail(long movieId) {
    if (!mAndroidHelper.isApiConfigurationExisted()) {
      Subscription subscription = mInteractor
          .loadApiConfiguration()
          .observeOn(mSchedulerProvider.mainThread())
          .subscribe(configuration -> {
            mAndroidHelper.saveApiConfiguration(configuration);
            handleMovieDetail(movieId);
          }, throwable -> {
            getView().hideLoading();
            getView().showErrorMessage(throwable);
          });
      addSubscription(subscription);
    } else {
      handleMovieDetail(movieId);
    }
  }

  private void handleMovieDetail(long movieId) {
    Subscription subscription = mInteractor
        .loadMovieDetail(movieId)
        .observeOn(mSchedulerProvider.mainThread())
        .subscribe(movie -> {
          getView().hideLoading();
          getView().setUpMovieDetail(movie);
        }, throwable -> {
          getView().hideLoading();
          getView().showErrorMessage(throwable);
        });
    addSubscription(subscription);
  }

}
