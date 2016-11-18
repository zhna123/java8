package com.nz.java.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhna123 on 11/18/16.
 */
public class TestConcurrency {

    public static void main(String[] args) {

        // implement Runnable - void run()
//        Runnable task = () -> {
//            String threadName = Thread.currentThread().getName();
//            System.out.println("Hello, " + threadName);
//        };
//
//        // first we execute the runnable directly
//        task.run();
//
//        Thread thread = new Thread(task);
//        // then we start a new thread
//        thread.start();
//
//        System.out.println("Done!");

        Runnable runnable = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println("Foo " + name);

                TimeUnit.SECONDS.sleep(1);

                System.out.println("Bar " + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
