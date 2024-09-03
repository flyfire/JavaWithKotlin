package com.solarexsoft.javawithkotlin.rx;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by Solarex on 2024/08/12 11:02
 */
public class SplitPage {
    public static void main(String[] args) throws InterruptedException {
        splitPage(100, 20);
        Thread.sleep(1000);
    }

    public static void splitPage(int allSize, int pageSize) {
        Observable.just(allSize)
                .flatMap(new Function<Integer, ObservableSource<List<Integer>>>() {
                    @Override
                    public ObservableSource<List<Integer>> apply(@NotNull Integer count) throws Exception {
                        return Observable.range(0, (count + pageSize - 1)/pageSize)
                                .flatMap(new Function<Integer, ObservableSource<List<Integer>>>() {
                                    @Override
                                    public ObservableSource<List<Integer>> apply(@NotNull Integer page) throws Exception {
                                        System.out.println("page = " + page);
                                        List<Integer> list = new ArrayList<>();
                                        int i = page * pageSize;
                                        int j = (page + 1) * pageSize - 1;
                                        for (int k = i; k <= j; k++) {
                                            list.add(k);
                                        }
                                        return Observable.just(list);
                                    }
                                });
                    }
                })
                .flatMapIterable(new Function<List<Integer>, Iterable<Integer>>() {
                    @Override
                    public Iterable<Integer> apply(@NotNull List<Integer> list) throws Exception {
                        return list;
                    }
                })
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println(String.valueOf(integer));
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println(throwable.getLocalizedMessage());
                    }
                });
    }
}
