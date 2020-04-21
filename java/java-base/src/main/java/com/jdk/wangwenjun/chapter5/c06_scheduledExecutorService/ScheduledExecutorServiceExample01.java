package com.jdk.wangwenjun.chapter5.c06_scheduledExecutorService;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author taobaibai
 * @create 2020-04-21 12:38
 */
public class ScheduledExecutorServiceExample01 {
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

    public static void test() throws ExecutionException, InterruptedException {
        ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(2);

//        ScheduledFuture<?> future = executor.schedule(() -> System.out.println("====I will be invoked!"), 2, TimeUnit.SECONDS);
//        System.out.println(future.cancel(true));

//        ScheduledFuture<Integer> future1 = executor.schedule(() -> 2, 2, TimeUnit.SECONDS);
//        System.out.println(future1.get());

//        ScheduledFuture<?> future = executor.scheduleAtFixedRate(() -> System.out.println("I am Running @" + System.currentTimeMillis()), 1, 2, TimeUnit.SECONDS);

    }

    private static void testScheduleWithFixedDelay() {
//        ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(2);
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(2);
        System.out.println(String.valueOf(executor.getExecuteExistingDelayedTasksAfterShutdownPolicy()));

        final AtomicLong interval = new AtomicLong();
        ScheduledFuture<?> future = executor.scheduleWithFixedDelay(() -> {
            long currentTimeMillis = System.currentTimeMillis();
            if(interval.get()==0){
                System.out.printf("The first time trigger task at %d\n", currentTimeMillis);
            }else {
                System.out.printf("The actually spend [%d]\n", currentTimeMillis-interval.get());
            }
            sleep(5, TimeUnit.SECONDS);
            interval.set(currentTimeMillis);
        }, 1, 2, TimeUnit.SECONDS);

        sleep(1200, TimeUnit.MILLISECONDS);
        executor.shutdown();
    }

    private static void testScheduleAtFixedRate() {
//        ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(2);;
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(2);

        System.out.println(String.valueOf(executor.getContinueExistingPeriodicTasksAfterShutdownPolicy()));

        final AtomicLong interval = new AtomicLong();
        ScheduledFuture<?> future = executor.scheduleAtFixedRate(() -> {
            long currentTimeMillis = System.currentTimeMillis();
            if(interval.get()==0){
                System.out.printf("The first time trigger task at %d\n", currentTimeMillis);
            }else {
                System.out.printf("The actually spend [%d]\n", currentTimeMillis-interval.get());
            }
            sleep(5, TimeUnit.SECONDS);
            interval.set(currentTimeMillis);
        }, 1, 2, TimeUnit.SECONDS);

        sleep(1200, TimeUnit.MILLISECONDS);
        executor.shutdown();
    }

    private static void test1() {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(2);

        System.out.println(String.valueOf(executor.getContinueExistingPeriodicTasksAfterShutdownPolicy()));

        final AtomicLong interval = new AtomicLong();
        ScheduledFuture<?> future = executor.scheduleAtFixedRate(() -> {
            long currentTimeMillis = System.currentTimeMillis();
            System.out.printf(Thread.currentThread().getName()+"\t\t");
            if(interval.get()==0){
                System.out.printf("The first time trigger task at %d\n", currentTimeMillis);
            }else {
                System.out.printf("The actually spend [%d]\n", currentTimeMillis-interval.get());
            }
            interval.set(currentTimeMillis);
            sleep(5, TimeUnit.SECONDS);
        }, 1, 2, TimeUnit.SECONDS);

        sleep(1200, TimeUnit.MILLISECONDS);
        executor.shutdown();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        test1();
        testScheduleWithFixedDelay();
    }
}
