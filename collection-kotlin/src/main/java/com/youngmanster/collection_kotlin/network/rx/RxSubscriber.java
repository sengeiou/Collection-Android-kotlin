package com.youngmanster.collection_kotlin.network.rx;


import com.youngmanster.collection_kotlin.network.NetWorkCodeException;

import io.reactivex.observers.DisposableObserver;

/**
 * Observer的处理事件
 * Created by yangyan
 * on 2018/3/17.
 */

public abstract class RxSubscriber<T> extends DisposableObserver<T> {

    @Override
    public void onNext(T t) {
        if (isDisposed()) {
            return;
        }else{
            dispose();
        }
        _onNext(t);
    }

    @Override
    public void onError(Throwable e) {
        if (isDisposed()) {
            return;
        }else{
            dispose();
        }
        _onError(NetWorkCodeException.Companion.getResponseThrowable(e));
    }

    @Override
    public void onComplete() {
        if (isDisposed()) {
           return;
        }else{
            dispose();
        }
        _onComplete();
    }

    /**
     * 定义处理事件
     */
    public abstract void _onNext(T t);
    public abstract void _onError(NetWorkCodeException.ResponseThrowable e);
    public abstract void _onComplete();
}
