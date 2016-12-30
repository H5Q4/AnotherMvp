package com.szhr.anothermvp.core.util;

import rx.Scheduler;

@SuppressWarnings("unused")
public interface SchedulerProvider {

  Scheduler mainThread();

  Scheduler backgroundThread();

}
