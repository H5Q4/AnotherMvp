package com.szhr.anothermvp.ui.movie.popular.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.LayoutRes;
import android.support.v4.media.VolumeProviderCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.annimon.stream.Stream;
import com.annimon.stream.function.Function;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.github.jupittar.commlib.custom.AspectRatioImageView;
import com.github.jupittar.commlib.custom.recyclerview.CommonViewHolder;
import com.github.jupittar.commlib.custom.recyclerview.adapter.CommonViewAdapter;
import com.github.jupittar.commlib.utilities.WindowUtils;
import com.szhr.anothermvp.R;
import com.szhr.anothermvp.core.data.entity.Movie;
import com.szhr.anothermvp.util.TmdbApiConfigurationUtils;

import java.util.Comparator;

public class PopularMoviesRecyclerViewAdapter extends CommonViewAdapter<Movie> {

  private static int mIvPosterWidth;

  public PopularMoviesRecyclerViewAdapter(Context context, @LayoutRes int layoutId) {
    super(context, layoutId);
    mIvPosterWidth = WindowUtils.getScreenWidth((AppCompatActivity) context);
  }

  @Override
  public void convertView(CommonViewHolder holder, Movie movie) {
    RelativeLayout rlMovieInfo = holder.getView(R.id.rl_movie_info);
    final AspectRatioImageView ivPoster = holder.getView(R.id.iv_movie_poster);
    TextView tvTitle = holder.getView(R.id.tv_movie_title);
    TextView tvReleaseDate = holder.getView(R.id.tv_release_date);
    ivPoster.setAspectRatio(AspectRatioImageView.PHI);
    String imagePath = String.format("%s%s%s",
        TmdbApiConfigurationUtils.getSecureBaseUrl(mContext),
        TmdbApiConfigurationUtils.getPosterSize(mContext),
        movie.getBackdropPath());
    BitmapImageViewTarget ivPosterTarget = new BitmapImageViewTarget(ivPoster) {
      @Override
      public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
        super.onResourceReady(bitmap, glideAnimation);
        Palette.from(bitmap).generate(palette -> {
          if (palette != null) {
            Stream.of(palette.getSwatches())
                .max((o1, o2) -> o1.getPopulation() > o2.getPopulation() ? 1 : 0)
                .map(swatch -> {
                  rlMovieInfo.setBackgroundColor(swatch.getRgb());
                  return null;
                });
          }
        });
      }
    };
    Glide.with(mContext)
        .load(imagePath)
        .asBitmap()
        .override(mIvPosterWidth, (int) (mIvPosterWidth * AspectRatioImageView.PHI))
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .centerCrop()
        .into(ivPosterTarget);
    tvTitle.setText(movie.getOriginalTitle());
    tvReleaseDate.setText(movie.getReleaseDate());
  }

}
