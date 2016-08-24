package com.example.administrator.every_sample.http;

import rx.Subscriber;

/**
 * Created by Administrator on 2016/8/24.
 */
public abstract class HttpSubscriber<T> extends Subscriber<T>{

    public abstract void onSuccess(T t);
    public abstract void onFailure(String message);

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        onFailure(e.getMessage());
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }
}
