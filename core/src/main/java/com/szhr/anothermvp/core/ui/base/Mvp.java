package com.szhr.anothermvp.core.ui.base;

import com.szhr.anothermvp.core.data.entity.Configuration;

import rx.Observable;
import rx.Subscription;

@SuppressWarnings("unused")
public interface Mvp {

  interface Interactor {
    Observable<Configuration> loadApiConfiguration();
  }

  interface View {
    void showLoading();
    void hideLoading();
  }

  interface Presenter<V extends View> {
    void attach(V view);
    void detach();
    void addSubscription(Subscription s);
    void unSubscribeAll();
  }

}
