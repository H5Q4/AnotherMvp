package com.szhr.anothermvp.ui.movie.popular;

import com.szhr.anothermvp.core.ui.movie.popular.PopularMoviesScope;

import dagger.Subcomponent;

@Subcomponent(modules = {
    AppPopularMoviesModule.class
})
@PopularMoviesScope
public interface PopularMoviesSubComponent {

  void inject(PopularMoviesFragment fragment);

}
