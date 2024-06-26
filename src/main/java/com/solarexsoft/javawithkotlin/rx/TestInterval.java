package com.solarexsoft.javawithkotlin.rx;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

/*
 * Created by Solarex on 2024/04/17 11:22
 */
public class TestInterval {
    public static void main(String[] args) {
        Observable.interval(0, 1, TimeUnit.SECONDS)
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(@NotNull Long aLong) throws Exception {
                        if (aLong != 0 && aLong % 5 == 0) {
                            throw new RuntimeException("map hit");
                        } else {
                            return aLong;
                        }
                    }
                })
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        System.out.println("hello " + aLong);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println("exception = " + throwable.getLocalizedMessage());
                    }
                });
        Observable.interval(0, 1, TimeUnit.SECONDS)
                .flatMap(new Function<Long, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(@NotNull Long aLong) throws Exception {
                        if (aLong != 0 && aLong % 5 == 0) {
                            throw new RuntimeException("flatmap hit");
                        } else {
                            return Observable.fromArray(String.valueOf(aLong), "solarex");
                        }
                    }
                }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("world " + s);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                System.out.println("exception = " + throwable.getLocalizedMessage());
            }
        });
        try {
            Thread.sleep(10 * 1000);
        } catch (Throwable throwable) {

        }
    }
}
