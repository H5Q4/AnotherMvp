package com.szhr.anothermvp.core.ui.popular_movies;

import com.szhr.anothermvp.core.ui.base.BasePresenter;
import com.szhr.anothermvp.core.ui.base.Mvp;

@SuppressWarnings("unused")
public interface PopularMoviesMvp {

  interface Interactor extends Mvp.Interactor {}

  interface View extends Mvp.View {}

  abstract class Presenter<V extends View> extends BasePresenter<V> {}

}
