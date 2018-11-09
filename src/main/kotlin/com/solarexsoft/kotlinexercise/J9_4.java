package com.solarexsoft.kotlinexercise;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

import java.util.ArrayList;

/**
 * Created by houruhou on 2018/11/9.
 * Desc:
 */
public class J9_4 {
    private ArrayList<Runnable> runnables = new ArrayList<>();

    public void addTask(Runnable runnable) {
        runnables.add(runnable);
        System.out.println("After add: " + runnable + ",we have " + runnables.size() + " in all.");
    }

    public void removeTask(Runnable runnable) {
        runnables.remove(runnable);
        System.out.println("After remove " + runnable + ",only " + runnables.size() + " left.");
    }

    public static void main(String[] args) {
        SAMInKotlin sam = new SAMInKotlin();
        sam.addTask(new Function0<Unit>() {
            @Override
            public Unit invoke() {
                System.out.println("nothing will happen");
                return null;
            }
        });
    }
}
