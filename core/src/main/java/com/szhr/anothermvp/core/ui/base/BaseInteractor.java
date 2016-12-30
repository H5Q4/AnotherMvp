package com.szhr.anothermvp.core.ui.base;

import com.szhr.anothermvp.core.util.SchedulerProvider;
import com.szhr.anothermvp.core.data.entity.Configuration;
import com.szhr.anothermvp.core.data.remote.TmdbService;

import rx.Observable;

public class BaseInteractor implements Mvp.Interactor {

  protected TmdbService mTmdbService;
  protected SchedulerProvider mSchedulerProvider;

  public BaseInteractor(TmdbService tmdbService, SchedulerProvider schedulerProvider) {
    mTmdbService = tmdbService;
    mSchedulerProvider = schedulerProvider;
  }

  public Observable<Configuration> loadApiConfiguration() {
    return mTmdbService
        .getApiConfiguration()
        .subscribeOn(mSchedulerProvider.backgroundThread());
  }

}
