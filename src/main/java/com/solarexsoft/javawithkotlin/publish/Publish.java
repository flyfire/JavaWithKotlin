package com.solarexsoft.javawithkotlin.publish;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

/*
 * Created by Solarex on 2023/08/18 17:23
 */
public class Publish {
    public static void main(String[] args) throws InterruptedException {
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS)
                .publish();
        Disposable disposable1 = observable.subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                System.out.println("observer1: " + aLong);
            }
        });
        Completable.timer(5, TimeUnit.SECONDS)
                .subscribe(new Action() {
                    @Override
                    public void run() throws Exception {
                        Disposable disposable2 = observable.subscribe(new Consumer<Long>() {
                            @Override
                            public void accept(Long aLong) throws Exception {
                                System.out.println("observer2: " + aLong);
                            }
                        });
                    }
                });
        Disposable disposable3 = ((ConnectableObservable<Long>) observable).connect();
        Thread.sleep(10 * 1000);
    }
}
