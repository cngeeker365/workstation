package com.jdk.wangwenjun.chapter5.c01_threadPoolExecutor;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author taobaibai
 * @create 2020-04-19 16:24
 */
public class ThreadPoolExecutorLongTimeTask {

    public static ExecutorService buildThreadPoolExecutor() {
        ExecutorService executorService = new ThreadPoolExecutor(10, 20, 30, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                r -> {
                    Thread t = new Thread(r);
                    t.setDaemon(true);
                    return t;
                }, new ThreadPoolExecutor.AbortPolicy());
        System.out.println("The ThreadPoolExecutor create done.");
        return executorService;
    }

    private static void sleepSeconds(long seconds) {
        try {
            System.out.println("* " + Thread.currentThread().getName() + " *");
            TimeUnit.SECONDS.sleep(seconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) buildThreadPoolExecutor();
        IntStream.range(0, 10).boxed().forEach(i -> {
            executorService.submit(() -> {
                while (true) {

                }
            });
        });
        executorService.shutdownNow();
        executorService.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("==========================start the sequence work===========================");
    }
}
