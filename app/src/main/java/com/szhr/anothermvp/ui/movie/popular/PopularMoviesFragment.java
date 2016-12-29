package com.szhr.anothermvp.ui.movie.popular;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.szhr.anothermvp.AppComponent;
import com.szhr.anothermvp.R;
import com.szhr.anothermvp.core.ui.movie.popular.PopularMoviesPresenter;
import com.szhr.anothermvp.core.ui.movie.popular.PopularMoviesView;
import com.szhr.anothermvp.ui.base.BaseFragment;
import com.szhr.anothermvp.util.SharedPreferencesManager;

import javax.inject.Inject;

import butterknife.BindView;

public class PopularMoviesFragment extends BaseFragment implements PopularMoviesView {

  public static final String TAG = PopularMoviesFragment.class.getSimpleName();

  @Inject
  OnFragmentInteractionListener mListener;
  @Inject
  PopularMoviesPresenter mPresenter;

  @BindView(R.id.recycler_view)
  RecyclerView mRecyclerView;
  @BindView(R.id.layout_loading)
  ProgressBar mProgressBar;
  @BindView(R.id.layout_error)
  View mLayoutError;

  public PopularMoviesFragment() {
    // Required empty public constructor
  }

  public static PopularMoviesFragment newInstance() {
    PopularMoviesFragment fragment = new PopularMoviesFragment();
    return fragment;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    setUpRecyclerView();
  }

  private void setUpRecyclerView() {
    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    mRecyclerView.setLayoutManager(layoutManager);

  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_popular_movies, container, false);
  }

  @Override
  public void onDetach() {
    super.onDetach();
    mListener = null;
    mPresenter.detach();
    mPresenter = null;
  }

  @Override
  protected void injectDependencies(Context context, AppComponent component) {
    component
        .plus(new AppPopularMoviesModule(context, this))
        .inject(this);
  }

  @Override
  public void showLoading() {
    mProgressBar.setVisibility(View.VISIBLE);
  }

  @Override
  public void hideLoading() {
    mProgressBar.setVisibility(View.GONE);
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
