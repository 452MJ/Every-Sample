package com.example.administrator.every_sample.http.retrofit;

import rx.Subscriber;

/**
 * 订阅处理T事件的抽象类
 * Created by Administrator on 2016/8/24.
 */
public abstract class HttpSubscriber<T> extends Subscriber<T>{

    public abstract void _onNext(T t);
    public abstract void _onError(String message);

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        _onError(e.getMessage());
    }

    @Override
    public void onNext(T t) {
        _onNext(t);
    }
}
