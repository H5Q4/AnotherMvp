package com.szhr.anothermvp.ui.movie.detail;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.szhr.anothermvp.AppComponent;
import com.szhr.anothermvp.R;
import com.szhr.anothermvp.core.data.entity.Movie;
import com.szhr.anothermvp.core.ui.movie.detail.MovieDetailMvp;
import com.szhr.anothermvp.ui.base.BaseFragment;
import com.szhr.anothermvp.ui.movie.popular.AppPopularMoviesModule;

public class MovieDetailFragment extends BaseFragment implements MovieDetailMvp.View {

  public MovieDetailFragment() {
  }

  public static MovieDetailFragment newInstance() {
    MovieDetailFragment fragment = new MovieDetailFragment();
    return fragment;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_movie_detail, container, false);
  }

  @Override
  protected void injectDependencies(Context context, AppComponent component) {
    component
        .plus(new AppMovieDetailModule(context, this))
        .inject(this);
  }

  @Override
  public void setUpMovieDetail(Movie movie) {

  }

  @Override
  public void showLoading() {

  }

  @Override
  public void hideLoading() {

  }

  @Override
  public void showErrorMessage(Throwable throwable) {

  }

  /**
   * This interface must be implemented by activities that contain this
   * fragment to allow an interaction in this fragment to be communicated
   * to the activity and potentially other fragments contained in that
   * activity.
   */
  public interface OnFragmentInteractionListener {
  }

}
