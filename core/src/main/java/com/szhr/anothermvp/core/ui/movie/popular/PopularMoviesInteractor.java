package com.szhr.anothermvp.core.ui.movie.popular;

import com.szhr.anothermvp.core.util.SchedulerProvider;
import com.szhr.anothermvp.core.data.entity.Movie;
import com.szhr.anothermvp.core.data.entity.RawResponse;
import com.szhr.anothermvp.core.data.remote.TmdbService;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

@PopularMoviesScope
class PopularMoviesInteractor extends PopularMoviesMvp.Interactor {

  @Inject
  public PopularMoviesInteractor(TmdbService tmdbService, SchedulerProvider schedulerProvider) {
    super(tmdbService, schedulerProvider);
  }

  @Override
  public Observable<List<Movie>> loadMovies(int page) {
    return mTmdbService
        .getPopularMovies(page)
        .subscribeOn(mSchedulerProvider.backgroundThread())
        .map(RawResponse::getResults);
  }

}
