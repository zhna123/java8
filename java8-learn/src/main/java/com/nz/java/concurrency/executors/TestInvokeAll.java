package com.nz.java.concurrency.executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhna123 on 11/18/16.
 *
 * batch submitting - invokeAll
 */
public class TestInvokeAll {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
                () -> "task1",
                () -> "task2",
                () -> "task3"
        );

        try {
            executorService.invokeAll(callables)
                    .stream()
                    .map(future -> {
                        try {
                            return future.get();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .forEach(System.out :: println);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
