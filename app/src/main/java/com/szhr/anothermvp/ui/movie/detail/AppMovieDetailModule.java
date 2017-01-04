package com.szhr.anothermvp.ui.movie.detail;

import android.content.Context;

import com.szhr.anothermvp.core.ui.movie.detail.MovieDetailModule;
import com.szhr.anothermvp.core.ui.movie.detail.MovieDetailScope;

import dagger.Module;
import dagger.Provides;

@Module
@SuppressWarnings("unused")
public class AppMovieDetailModule extends MovieDetailModule {

  private MovieDetailFragment.OnFragmentInteractionListener mListener;

  AppMovieDetailModule(Context context, MovieDetailFragment fragment) {
    super(fragment);

    if (context instanceof MovieDetailFragment.OnFragmentInteractionListener) {
      mListener = (MovieDetailFragment.OnFragmentInteractionListener) context;
    } else {
      throw new RuntimeException(context.toString()
          + " must implement OnFragmentInteractionListener");
    }
  }

  @Provides
  @MovieDetailScope
  MovieDetailFragment.OnFragmentInteractionListener provideOnFragmentInteractionListener() {
    return mListener;
  }
}
