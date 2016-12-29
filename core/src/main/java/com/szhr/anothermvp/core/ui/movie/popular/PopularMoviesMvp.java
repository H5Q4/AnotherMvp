package com.szhr.anothermvp.core.ui.movie.popular;

import com.szhr.anothermvp.core.data.entity.Movie;
import com.szhr.anothermvp.core.ui.base.BasePresenter;
import com.szhr.anothermvp.core.ui.base.Mvp;

import java.util.List;

import rx.Observable;

@SuppressWarnings("unused")
public interface PopularMoviesMvp {

  interface Interactor extends Mvp.Interactor {
     Observable<List<Movie>> loadMovies(int page);
  }

  interface View extends Mvp.View {}

  abstract class Presenter<V extends View> extends BasePresenter<V> {
    abstract void showPopularMovies(int page);
  }

}
