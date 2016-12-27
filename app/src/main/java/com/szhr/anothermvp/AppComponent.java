package com.szhr.anothermvp;

import com.szhr.anothermvp.core.data.remote.NetworkModule;
import com.szhr.anothermvp.ui.hotmovies.HotMoviesActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
    AppModule.class,
    NetworkModule.class
})
public interface AppComponent {

  void inject(HotMoviesActivity activity);

}
