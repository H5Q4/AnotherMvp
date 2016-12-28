package com.szhr.anothermvp;

import com.szhr.anothermvp.core.SchedulerProvider;

import javax.inject.Inject;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@SuppressWarnings("unused")
public class AppSchedulerProvider implements SchedulerProvider {

  @Inject
  public AppSchedulerProvider() {
  }

  @Override
  public Scheduler mainThread() {
    return AndroidSchedulers.mainThread();
  }

  @Override
  public Scheduler backgroundThread() {
    return Schedulers.io();
  }
}
