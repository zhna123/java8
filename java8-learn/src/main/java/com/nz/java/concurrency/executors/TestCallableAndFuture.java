package com.nz.java.concurrency.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhna123 on 11/18/16.
 */
public class TestCallableAndFuture {

    public static void main(final String[] args) {

        final Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };

        try {


            final ExecutorService executorService = Executors.newFixedThreadPool(1);
            final Future<Integer> future = executorService.submit(task);

            System.out.println("future done? " + future.isDone());

            final Integer result = future.get();

            System.out.println("future done? " + future.isDone());
            System.out.println("result: " + result);

        } catch (InterruptedException e) {
            throw new RuntimeException("interrupted future.get", e);
        } catch (ExecutionException ee) {
            throw new RuntimeException("execution exception", ee);
        }
    }
}
