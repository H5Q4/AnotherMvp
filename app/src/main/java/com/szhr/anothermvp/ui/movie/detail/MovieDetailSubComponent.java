package com.szhr.anothermvp.ui.movie.detail;

import com.szhr.anothermvp.core.ui.movie.detail.MovieDetailScope;

import dagger.Subcomponent;

@MovieDetailScope
@Subcomponent(modules = {
    AppMovieDetailModule.class
})
public interface MovieDetailSubComponent {

  void inject(MovieDetailFragment fragment);

}
