package com.szhr.anothermvp.ui.movie.popular;

import com.szhr.anothermvp.core.ui.movie.popular.PopularMoviesScope;

import dagger.Subcomponent;

@PopularMoviesScope
@Subcomponent(modules = {
    AppPopularMoviesModule.class
})
public interface PopularMoviesSubComponent {

  void inject(PopularMoviesFragment fragment);

}
