package com.szhr.anothermvp.core.ui.hotmovies;

import com.szhr.anothermvp.core.ui.base.BasePresenter;
import com.szhr.anothermvp.core.ui.base.Mvp;

public interface HotMoviesMvp {

  interface View extends Mvp.View {}

  abstract class Presenter<V extends View> extends BasePresenter<V> {}

}
