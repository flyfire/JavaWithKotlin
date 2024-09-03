package com.solarexsoft.javawithkotlin.rx;

import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/*
 * Created by Solarex on 2024/09/03 09:57
 */
public class AmbArray {
    public static void main(String[] args) {
        Single<String> req1 = Single.just("response from req1")
                .delay(3, TimeUnit.SECONDS);
        Single<String> req2 = Single.just("response from req2")
                .delay(5, TimeUnit.SECONDS);
        Single<String> req3 = Single.just("response from req3")
                .delay(8, TimeUnit.SECONDS);
        Single<String> firstResponse = Single.ambArray(req1, req2, req3);
        firstResponse.subscribeOn(Schedulers.io())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println(s);
                    }
                });
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}
