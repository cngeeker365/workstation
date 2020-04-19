package com.jdk.wangwenjun.chapter5.c01_threadPoolExecutor;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author taobaibai
 * @create 2020-04-19 16:24
 */
public class ThreadPoolExecutorBuild {
    /**
     * 测试点 Test Point：
     * [1] coreSize=1, MaxSize=2, blockingQueue is empty, submit 3 tasks ==> what happen?
     * [2] coreSize=1, MaxSize=2, blockingQueue size = 5, submit 7 tasks ==> what happen?
     * [2] coreSize=1, MaxSize=2, blockingQueue size = 5, submit 8 tasks ==> what happen?
     * int corePoolSize,
     * int maximumPoolSize,
     * long keepAliveTime,
     * TimeUnit unit,
     * BlockingQueue<Runnable> workQueue,
     * RejectedExecutionHandler handler
     * @return
     */
    public static ExecutorService buildThreadPoolExecutor() {
        ExecutorService executorService = new ThreadPoolExecutor(1, 2, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1), r -> {
            Thread t = new Thread(r);
            return t;
        }, new ThreadPoolExecutor.AbortPolicy());
        System.out.println("The ThreadPoolExecutor create done.");

        executorService.execute(()->sleepSeconds(100));
        executorService.execute(()->sleepSeconds(10));
        executorService.execute(()->sleepSeconds(10));
//        executorService.execute(()->sleepSeconds(100));
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

        int activeCount = 1;
        int queueSize=-1;

        while (true){
            if(activeCount!=executorService.getActiveCount() || queueSize!=executorService.getQueue().size()){
                System.out.println(executorService.getActiveCount());
                System.out.println(executorService.getCorePoolSize());
                System.out.println(executorService.getQueue().size());
                System.out.println(executorService.getMaximumPoolSize());
                activeCount = executorService.getActiveCount();
                queueSize = executorService.getQueue().size();
                System.out.println("============================================================");
            }
        }
    }
}
