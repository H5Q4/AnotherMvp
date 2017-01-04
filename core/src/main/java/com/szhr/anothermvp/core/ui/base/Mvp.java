package com.szhr.anothermvp.core.ui.base;

import rx.Subscription;

@SuppressWarnings("unused")
public interface Mvp {

  interface Interactor {}

  interface View {
    void showLoading();
    void hideLoading();

    void showErrorMessage(Throwable throwable);
  }

  interface Presenter<V extends View> {
    void attach(V view);
    void detach();
    void addSubscription(Subscription s);
    void unSubscribeAll();
  }

}
