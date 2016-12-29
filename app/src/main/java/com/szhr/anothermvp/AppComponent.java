package com.szhr.anothermvp;

import com.szhr.anothermvp.core.data.remote.NetworkModule;
import com.szhr.anothermvp.ui.movie.popular.AppPopularMoviesModule;
import com.szhr.anothermvp.ui.movie.popular.PopularMoviesActivity;
import com.szhr.anothermvp.ui.movie.popular.PopularMoviesSubComponent;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
    AppModule.class,
    NetworkModule.class
})
public interface AppComponent {

  void inject(PopularMoviesActivity activity);

  PopularMoviesSubComponent plus(AppPopularMoviesModule module);

}
