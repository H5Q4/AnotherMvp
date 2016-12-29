package com.szhr.anothermvp.core.ui.movie.popular;

import com.szhr.anothermvp.core.SchedulerProvider;
import com.szhr.anothermvp.core.data.entity.Configuration;
import com.szhr.anothermvp.core.data.entity.Movie;
import com.szhr.anothermvp.core.data.entity.RawResponse;
import com.szhr.anothermvp.core.data.remote.TmdbService;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

@PopularMoviesScope
@SuppressWarnings("unused")
class PopularMoviesInteractor implements PopularMoviesMvp.Interactor {

  private TmdbService mTmdbService;
  private SchedulerProvider mSchedulerProvider;

  @Inject
  public PopularMoviesInteractor(TmdbService tmdbService, SchedulerProvider schedulerProvider) {
    mTmdbService = tmdbService;
    mSchedulerProvider = schedulerProvider;
  }

  @Override
  public Observable<List<Movie>> loadMovies(int page) {
    return mTmdbService
        .getPopularMovies(page)
        .subscribeOn(mSchedulerProvider.backgroundThread())
        .map(RawResponse::getResults);
  }

  @Override
  public Observable<Configuration> loadApiConfiguration() {
    return null;
  }
}
