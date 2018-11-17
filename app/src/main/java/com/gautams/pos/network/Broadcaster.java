package com.gautams.pos.network;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * User Name: gautams2
 * Create Date : 9/22/2018
 */
public class Broadcaster<T> {
    public Broadcaster() {
    }

    private PublishSubject<T> publishSubject = PublishSubject.create();

    public void send(T t) {
        publishSubject.onNext(t);
    }

    public Observable<T> toObservable() {
        return publishSubject;
    }
}
