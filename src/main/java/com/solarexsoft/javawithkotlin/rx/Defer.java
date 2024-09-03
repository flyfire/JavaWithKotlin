package com.solarexsoft.javawithkotlin.rx;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;

import java.util.concurrent.Callable;

/*
 * Created by Solarex on 2024/08/12 15:23
 */
public class Defer {
    private static int i = 1;
    public static void main(String[] args) {
        Observable<String> observable = Observable.defer(new Callable<ObservableSource<? extends String>>() {
            @Override
            public ObservableSource<? extends String> call() throws Exception {
                if (getBoolean()) {
                    return Observable.just("condition is true, now = " + System.currentTimeMillis());
                } else {
                    return Observable.just("condition is false, now = " + System.currentTimeMillis());
                }
            }
        });
        observable.subscribe(System.out::println);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        i = 2;
        observable.subscribe(System.out::println);
    }

    private static boolean getBoolean() {
        return i == 1;
    }
}
