package com.szhr.anothermvp.ui.movie.detail;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.szhr.anothermvp.AppComponent;
import com.szhr.anothermvp.R;
import com.szhr.anothermvp.ui.base.BaseFragment;

/**
 * A placeholder fragment containing a simple view.
 */
public class MovieDetailFragment extends BaseFragment {

  public MovieDetailFragment() {
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_movie_detail, container, false);
  }

  @Override
  protected void injectDependencies(Context context, AppComponent component) {

  }
}
