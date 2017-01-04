package com.szhr.anothermvp.core.ui.movie.detail;

import com.szhr.anothermvp.core.data.entity.Movie;
import com.szhr.anothermvp.core.data.remote.TmdbService;
import com.szhr.anothermvp.core.ui.base.BaseInteractor;
import com.szhr.anothermvp.core.ui.base.BasePresenter;
import com.szhr.anothermvp.core.ui.base.Mvp;
import com.szhr.anothermvp.core.util.SchedulerProvider;

import rx.Observable;

public interface MovieDetailMvp {

  abstract class Interactor extends BaseInteractor {

    public Interactor(TmdbService tmdbService, SchedulerProvider schedulerProvider) {
      super(tmdbService, schedulerProvider);
    }

    abstract Observable<Movie> loadMovieDetail(long movieId);
  }

  interface View extends Mvp.View {
    void setUpMovieDetail(Movie movie);
  }

  abstract class Presenter<V extends View> extends BasePresenter<V> {

    abstract void showMovieDetail(long movieId);

  }

}
