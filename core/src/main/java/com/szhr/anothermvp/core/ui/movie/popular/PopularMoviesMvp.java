package com.szhr.anothermvp.core.ui.movie.popular;

import com.szhr.anothermvp.core.util.SchedulerProvider;
import com.szhr.anothermvp.core.data.entity.Movie;
import com.szhr.anothermvp.core.data.remote.TmdbService;
import com.szhr.anothermvp.core.ui.base.BaseInteractor;
import com.szhr.anothermvp.core.ui.base.BasePresenter;
import com.szhr.anothermvp.core.ui.base.Mvp;

import java.util.List;

import rx.Observable;

@SuppressWarnings("unused")
public interface PopularMoviesMvp {

  abstract class Interactor extends BaseInteractor {

    public Interactor(TmdbService tmdbService, SchedulerProvider schedulerProvider) {
      super(tmdbService, schedulerProvider);
    }

    public abstract Observable<List<Movie>> loadMovies(int page);

  }

  interface View extends Mvp.View {
    void showMovies(List<Movie> movies);
  }

  abstract class Presenter<V extends View> extends BasePresenter<V> {

    public abstract void showPopularMovies(int page);

  }

}
