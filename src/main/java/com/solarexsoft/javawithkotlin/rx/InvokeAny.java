package com.solarexsoft.javawithkotlin.rx;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/*
 * Created by Solarex on 2024/09/03 10:13
 */
public class InvokeAny {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Callable<String> task1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(3);
                return "response from task1";
            }
        };
        Callable<String> task2 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(5);
                return "response from task2";
            }
        };
        Callable<String> task3 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(8);
                return "response from task3";
            }
        };
        List<Callable<String>> taskList = Arrays.asList(task1, task2, task3);
        try {
            String firstResponse = executorService.invokeAny(taskList);
            System.out.println(firstResponse);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
