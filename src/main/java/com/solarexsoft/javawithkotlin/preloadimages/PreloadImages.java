package com.solarexsoft.javawithkotlin.preloadimages;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/*
 * Created by Solarex on 2025/06/25 14:42
 */
public class PreloadImages {
    public static void main(String[] args) throws InterruptedException {
        List<String> imageUrls = new ArrayList<>();
        imageUrls.add("1.png");
        imageUrls.add("2.png");
        imageUrls.add("3.png");
        imageUrls.add("4.png");
        Observable.fromIterable(imageUrls)
                .flatMap(new Function<String, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(@NotNull String s) throws Exception {
                        return Observable.fromCallable(new Callable<String>() {
                            @Override
                            public String call() throws Exception {
                                System.out.println(System.currentTimeMillis() + " preload " + s);
                                Thread.sleep(4000 + (int) (Math.random() * 1000));
                                return "preload " + s;
                            }
                        }).subscribeOn(Schedulers.io())
                                .onErrorResumeNext(Observable.empty());
                    }
                })
                .toList()
                .flatMap(new Function<List<String>, SingleSource<List<String>>>() {
                    @Override
                    public SingleSource<List<String>> apply(@NotNull List<String> strings) throws Exception {
                        System.out.println("preload complete: " + strings);
                        return Single.just(imageUrls);
                    }
                })
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<List<String>>() {
                    @Override
                    public void accept(List<String> strings) throws Exception {
                        System.out.println("subscribe preload completed: " + strings);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.err.println("preload error: " + throwable.getMessage());
                    }
                });
        Thread.sleep(200 * 1000);
    }
}
