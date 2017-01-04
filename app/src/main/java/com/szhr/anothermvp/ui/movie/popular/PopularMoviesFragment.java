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
import android.widget.Toast;

import com.github.jupittar.commlib.custom.recyclerview.EndlessScrollListener;
import com.github.jupittar.commlib.custom.recyclerview.adapter.CommonViewAdapter;
import com.szhr.anothermvp.AppComponent;
import com.szhr.anothermvp.R;
import com.szhr.anothermvp.core.data.entity.Configuration;
import com.szhr.anothermvp.core.data.entity.Movie;
import com.szhr.anothermvp.core.ui.movie.popular.PopularMoviesMvp;
import com.szhr.anothermvp.ui.base.BaseFragment;
import com.szhr.anothermvp.ui.movie.popular.adapter.PopularMoviesRecyclerViewAdapter;
import com.szhr.anothermvp.util.SharedPreferencesManager;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class PopularMoviesFragment
    extends BaseFragment
    implements PopularMoviesMvp.View {

  public static final String TAG = PopularMoviesFragment.class.getSimpleName();

  @Inject
  OnFragmentInteractionListener mListener;
  @Inject
  PopularMoviesMvp.Presenter<PopularMoviesMvp.View> mPresenter;

  @BindView(R.id.recycler_view)
  RecyclerView mRecyclerView;
  @BindView(R.id.layout_loading)
  ProgressBar mProgressBar;
  @BindView(R.id.layout_error)
  View mLayoutError;

  private int mPage = 1;

  private PopularMoviesRecyclerViewAdapter mPopularMoviesRecyclerViewAdapter;

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
    mPresenter.showPopularMovies(mPage);
  }

  private void setUpRecyclerView() {
    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    mRecyclerView.setLayoutManager(layoutManager);
    mRecyclerView.setHasFixedSize(true);
    mPopularMoviesRecyclerViewAdapter = new PopularMoviesRecyclerViewAdapter(getActivity(),
        R.layout.item_movie);
    mRecyclerView.setAdapter(mPopularMoviesRecyclerViewAdapter);
    mPopularMoviesRecyclerViewAdapter.setOnItemClickListener(
        (view, position) -> {
          SharedPreferencesManager.setConfiguration(getActivity(), null);
          Toast.makeText(getActivity(),
              "configuration deleted", Toast.LENGTH_LONG).show();
        });
    mRecyclerView.addOnScrollListener(new EndlessScrollListener() {
      @Override
      public void onLoadMore() {
        mPage++;
        mPresenter.showPopularMovies(mPage);
      }
    });
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

  @Override
  public void showErrorMessage(Throwable throwable) {
    Toast.makeText(getActivity(), throwable.getMessage(), Toast.LENGTH_LONG).show();
  }

  @Override
  public void showMovies(List<Movie> movies) {
    mPopularMoviesRecyclerViewAdapter.addAll(movies);
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
