package com.solarexsoft.javawithkotlin;

/**
 * Created by houruhou on 2018/10/25.
 * Desc:
 */
public class Closure {
    public static void test1(int a) {
        final int[] arr = {a};
        new Thread(new Runnable() {
            @Override
            public void run() {
                arr[0]++;
            }
        }).start();
    }

    public static void test2() {
        int count = 10;
        Ref<Integer> ref = new Ref<>();
        ref.element = count;
        new Thread(new Runnable() {
            @Override
            public void run() {
                ref.element++;
            }
        }).start();
    }
}
