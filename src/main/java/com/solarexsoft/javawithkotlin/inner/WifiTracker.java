package com.solarexsoft.javawithkotlin.inner;

/*
 * Created by Solarex on 2024/04/19 16:36
 */
public class WifiTracker {
    private class Scanner {
        Scanner() {
        }

        public void test() {
            System.out.println("scanner");
        }
    }

    public void test() {
        // 不在static方法里面，可以这样写
        Scanner scanner = new WifiTracker.Scanner();
        scanner.test();
    }

    public static void main(String[] args) {
        WifiTracker wifiTracker = new WifiTracker();
        wifiTracker.test();
        // WifiTracker.this cannot be referenced from a static context
//        Scanner scanner = new WifiTracker.Scanner();
    }
}
