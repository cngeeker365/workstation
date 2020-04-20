package com.jdk.wangwenjun.chapter5.c03_executorService;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author taobaibai
 * @create 2020-04-20 8:53
 */
public class ExecutorServiceRejectPolicy {
    private static void sleep(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 拒绝策略
     */
    public static void testAbortPolicy(){
        ExecutorService executorService = new ThreadPoolExecutor(1,2,30, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                r -> {
                    Runnable target;
                    Thread t = new Thread(r);
                    return t;
                }, new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 3; i++) {
            executorService.execute(()->sleep(100));
        }
        sleep(1);
        executorService.execute(()-> System.out.println("x"));
    }

    /**
     * 放弃策略
     */
    public static void testDiscardPolicy(){
        ExecutorService executorService = new ThreadPoolExecutor(1,2,30, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                r -> {
                    Runnable target;
                    Thread t = new Thread(r);
                    return t;
                }, new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 0; i < 3; i++) {
            executorService.execute(()->sleep(100));
        }
        sleep(1);
        executorService.execute(()-> System.out.println("x"));
    }

    /**
     * 放弃策略
     * ThreadPoolExecutors
     *          core[1]    max[2]     queue[1]
     * 提交第1个    1           2           empty       activeThread：1
     * 提交第2个    1           2           empty       activeThread：2
     * 提交第3个    1           2           1           activeThread：2      -unhandle task
     */
    public static void testDiscardOldestPolicy(){
        ExecutorService executorService = new ThreadPoolExecutor(1,2,30, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                r -> {
                    Runnable target;
                    Thread t = new Thread(r);
                    return t;
                }, new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 0; i < 3; i++) {
            executorService.execute(()->{
                sleep(5);
                System.out.println("I come from lambda.");
            });
        }
        executorService.execute(()-> {
            System.out.println("x");
            System.out.println(Thread.currentThread().getName());
        });
        System.out.println("==============================================");
    }

    /**
     * 使用调用者自己的线程的策略
     */
    public static void testCallerRunsPolicy(){
        ExecutorService executorService = new ThreadPoolExecutor(1,2,30, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                r -> {
                    Runnable target;
                    Thread t = new Thread(r);
                    return t;
                }, new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 3; i++) {
            executorService.execute(()->sleep(100));
        }
        sleep(1);
        executorService.execute(()-> {
            System.out.println("x");
            System.out.println(Thread.currentThread().getName());
        });
        System.out.println("=============================");
    }

    public static void main(String[] args) throws Exception {
//        testAbortPolicy();
//        testDiscardPolicy();
//        testCallerRunsPolicy();
        testDiscardOldestPolicy();
    }

}
