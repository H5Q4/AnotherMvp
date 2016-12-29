package com.szhr.anothermvp.ui.movie.popular;

import android.content.Context;

import com.szhr.anothermvp.core.ui.movie.popular.PopularMoviesModule;
import com.szhr.anothermvp.core.ui.movie.popular.PopularMoviesScope;

import dagger.Module;
import dagger.Provides;

@Module
@SuppressWarnings("unused")
public class AppPopularMoviesModule extends PopularMoviesModule {

  private PopularMoviesFragment.OnFragmentInteractionListener mListener;

  public AppPopularMoviesModule(Context context, PopularMoviesFragment fragment) {
    super(fragment);

    if (context instanceof PopularMoviesFragment.OnFragmentInteractionListener) {
      mListener = (PopularMoviesFragment.OnFragmentInteractionListener) context;
    } else {
      throw new RuntimeException(context.toString()
          + " must implement OnFragmentInteractionListener");
    }
  }

  @Provides
  @PopularMoviesScope
  public PopularMoviesFragment.OnFragmentInteractionListener provideOnFragmentInteractionListener() {
    return mListener;
  }
}
