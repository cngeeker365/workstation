package com.jdk.wangwenjun.chapter5.c01_threadPoolExecutor;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author taobaibai
 * @create 2020-04-19 16:24
 */
public class ThreadPoolExecutorTask {

    public static ExecutorService buildThreadPoolExecutor() {
        ExecutorService executorService = new ThreadPoolExecutor(10, 20, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), r -> {
            Thread t = new Thread(r);
            return t;
        }, new ThreadPoolExecutor.AbortPolicy());
        System.out.println("The ThreadPoolExecutor create done.");
        return executorService;
    }

    private static void sleepSeconds(long seconds){
        try {
            System.out.println("* " + Thread.currentThread().getName() + " *");
            TimeUnit.SECONDS.sleep(seconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor)buildThreadPoolExecutor();
        IntStream.range(0,20).boxed().forEach(i->{
            executorService.execute(()->{
                try {
                    TimeUnit.SECONDS.sleep(10);
                    System.out.println(Thread.currentThread().getName() + " [" + i + "] finish done.");
                } catch (Exception e) {
//                    e.printStackTrace();
                }
            });
        });
        /**
         * 20 Threads
         *      10  threads work
         *      10  idle
         * shutdown invoked
         *      10  waiting to finish the work
         *      10  interrupt the idle works
         *      20  idle thread will exist
         *
         * shutdownNow
         *      10  thread queue elements 10
         *      10  running
         *      10  stored in the blocking queue
         *      [1] return List<Runnable> remain 10 unhandle runnable
         *      [2] still work for the runnable for the core thread
         */
        try {
//            executorService.shutdown();
//            executorService.awaitTermination(1, TimeUnit.HOURS);
            List<Runnable> list = executorService.shutdownNow();
            System.out.println("==========================OVER============================");
            System.out.println(list);
            System.out.println(list.size());
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }
}
