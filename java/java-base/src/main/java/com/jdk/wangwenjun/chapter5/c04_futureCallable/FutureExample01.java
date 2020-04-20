package com.jdk.wangwenjun.chapter5.c04_futureCallable;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author taobaibai
 * @create 2020-04-20 21:08
 */
public class FutureExample01 {
    private static void sleep(long num, TimeUnit type) {
        try {
            switch (type) {
                case SECONDS:
                    TimeUnit.SECONDS.sleep(num);
                    break;
                case MILLISECONDS:
                    TimeUnit.MILLISECONDS.sleep(num);
                    break;
                default:
                    TimeUnit.HOURS.sleep(num);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * {@link Future#get()}
     *
     * @throws ExecutionException
     * @throws InterruptedException 打断的是 get 等待的线程，如 main线程，与线程池中的线程无关
     */
    public static void testGet() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        Future<Integer> future = executorService.submit(() -> {
            sleep(10, TimeUnit.SECONDS);
            return 10;
        });
        //======================================================================
        System.out.println("=========I will be printed quickly.==========");
        //======================================================================
        Thread callerThread = Thread.currentThread();
        new Thread(() -> {
            sleep(3, TimeUnit.MILLISECONDS);
            callerThread.interrupt();
        }).start();
        Integer result = future.get();
        System.out.println(result);
    }

    /**
     * 数据拷贝  src --[cp]--> dest
     * Job 运行 可能超时
     * [1] mapReduce
     * yarn applicationJobId
     * yarn -kill applicationJobId
     * deal with resource & garbage data
     * [2] linux
     * kill -0 processId
     * deal with resource & garbage data
     * <p>
     * {@link Future#get(long, TimeUnit)}
     *
     * @throws ExecutionException
     * @throws InterruptedException 打断的是 get 等待的线程，如 main线程，与线程池中的线程无关
     * @throws TimeoutException     不影响线程池的运行
     */
    public static void testGetWithTimeout() throws ExecutionException, InterruptedException, TimeoutException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        Future<Integer> future = executorService.submit(() -> {
            sleep(10, TimeUnit.SECONDS);
            System.out.println("==================");
            return 10;
        });
        //======================================================================
        System.out.println("=========I will be printed quickly.==========");
        //======================================================================
        Integer result = future.get(5, TimeUnit.SECONDS);
        System.out.println(result);
    }

    /**
     * Completion may be due to normal termination, an exception, or cancellation => true
     * {@link Future#isDone()}
     */
    public static void testIsDone() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        Future<Integer> future = executorService.submit(() -> {
//            sleep(10, TimeUnit.SECONDS);
//            return 10;
            throw new RuntimeException();
        });
        Integer result = null;
        try {
            result = future.get();
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(result + " is done " + future.isDone());
        }
    }

    /**
     * [1] try to cancel maybe failed.
     * +-- already completed
     * +-- already canceled
     * {@link Future#isDone()}
     */
    public static void testCancel() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        AtomicBoolean running = new AtomicBoolean(true);
        Future<Integer> future = executorService.submit(() -> {
//            sleep(10, TimeUnit.SECONDS);
            while (running.get()) {
            }
            return 10;
        });
        sleep(10, TimeUnit.MILLISECONDS);
        System.out.println(future.cancel(true));
        System.out.println(future.isDone());
        System.out.println(future.isCancelled());
//        System.out.println(future.cancel(true));
//        System.out.println(future.get());
    }

    /**
     * Cancel 一般要与 interrupted 一起使用
     * {@link Future#isDone()}
     */
    public static void testCancel_2() throws ExecutionException, InterruptedException {
        AtomicBoolean running = new AtomicBoolean(true);
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newCachedThreadPool(
//                new ThreadFactory() {
//                    @Override
//                    public Thread newThread(Runnable r) {
//                        Thread t = new Thread(r);
//                        //流氓的关闭
//                        t.setDaemon(true);
//                        return t;
//                    }
//                }
                );
        Future<Integer> future = executorService.submit(() -> {
            while(!Thread.interrupted()){
                //优雅的关闭
            }
//            while (running.get()) {
                //普通的关闭
//            }
            System.out.println("1111111111111111111111");
            return 10;
        });
        sleep(10, TimeUnit.MILLISECONDS);
        System.out.println(future.cancel(true));
        System.out.println(future.isDone());
        System.out.println(future.isCancelled());
        sleep(20, TimeUnit.MILLISECONDS);
        System.out.println(future.get());
    }

    public static void main(String[] args) throws Exception {
//        testGet();
//        testGetWithTimeout();
//        testIsDone();
//        testCancel();
        testCancel_2();
    }
}
