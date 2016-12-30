package com.szhr.anothermvp.ui.movie.popular.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.jupittar.commlib.custom.AspectRatioImageView;
import com.github.jupittar.commlib.custom.recyclerview.CommonViewHolder;
import com.github.jupittar.commlib.custom.recyclerview.adapter.CommonViewAdapter;
import com.szhr.anothermvp.R;
import com.szhr.anothermvp.core.data.entity.Movie;
import com.szhr.anothermvp.util.TmdbApiConfigurationUtils;

public class PopularMoviesRecyclerViewAdapter extends CommonViewAdapter<Movie> {

  public PopularMoviesRecyclerViewAdapter(Context context, @LayoutRes int layoutId) {
    super(context, layoutId);
  }

  @Override
  public void convertView(CommonViewHolder holder, Movie movie) {
    AspectRatioImageView ivPoster = holder.getView(R.id.iv_movie_poster);
    TextView tvTitle = holder.getView(R.id.tv_movie_title);
    TextView tvReleaseDate = holder.getView(R.id.tv_release_date);
    ivPoster.setAspectRatio(AspectRatioImageView.PHI);
    String imagePath = String.format("%s%s%s",
        TmdbApiConfigurationUtils.getSecureBaseUrl(mContext),
        TmdbApiConfigurationUtils.getPosterSize(mContext),
        movie.getBackdropPath());
    Glide.with(ivPoster.getContext())
        .load(imagePath)
        .centerCrop()
        .into(ivPoster);
    tvTitle.setText(movie.getOriginalTitle());
    tvReleaseDate.setText(movie.getReleaseDate());
  }

}