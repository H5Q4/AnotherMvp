package com.szhr.anothermvp.core.ui.movie.detail;

import com.szhr.anothermvp.core.data.entity.Movie;
import com.szhr.anothermvp.core.data.remote.TmdbService;
import com.szhr.anothermvp.core.util.SchedulerProvider;

import javax.inject.Inject;

import rx.Observable;

@MovieDetailScope
public class MovieDetailInteractor extends MovieDetailMvp.Interactor {

  @Inject
  public MovieDetailInteractor(TmdbService tmdbService, SchedulerProvider schedulerProvider) {
    super(tmdbService, schedulerProvider);
  }

  @Override
  Observable<Movie> loadMovieDetail(long movieId) {
    return mTmdbService
        .getMovieDetails(movieId)
        .subscribeOn(mSchedulerProvider.backgroundThread());
  }

}
