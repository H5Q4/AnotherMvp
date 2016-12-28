package com.szhr.anothermvp.core;

import rx.Scheduler;

@SuppressWarnings("unused")
public interface SchedulerProvider {

  Scheduler mainThread();

  Scheduler backgroundThread();

}
