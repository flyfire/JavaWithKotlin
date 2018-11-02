package com.solarexsoft.javawithkotlin;

/**
 * Created by houruhou on 2018/10/26.
 * Desc:
 */
public class ReturnType {
    interface Processor<T> {
        T process();
    }

    class Test implements Processor<Void>{
        @Override
        public Void process() {
            return null;
        }
    }
}
