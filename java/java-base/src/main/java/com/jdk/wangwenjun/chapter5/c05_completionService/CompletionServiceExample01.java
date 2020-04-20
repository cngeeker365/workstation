package com.jdk.wangwenjun.chapter5.c05_completionService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author taobaibai
 * @create 2020-04-20 22:15
 */
public class CompletionServiceExample01 {
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
     * No Callback
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private static void testFuture() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> future = executorService.submit(() -> {
            sleep(100, TimeUnit.SECONDS);
            return 100;
        });
        System.out.println("===============================");
        future.get();
    }

    private static void testFutureGroup() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Callable<Integer>> callableList = Arrays.asList(
                () -> {
                    sleep(10, TimeUnit.SECONDS);
                    System.out.println("The 10 finished");
                    return 10;
                },
                () -> {
                    sleep(20, TimeUnit.SECONDS);
                    System.out.println("The 20 finished");
                    return 20;
                }
        );
        /**
        List<Future<Integer>> futures = executorService.invokeAll(callableList);
        Integer v1 = futures.get(1).get();
        System.out.println(v1);
        Integer v2 = futures.get(0).get();
        System.out.println(v2);
         */

        List<Future<Integer>> futures = new ArrayList<>();
        futures.add(executorService.submit(callableList.get(0)));
        futures.add(executorService.submit(callableList.get(1)));
        for(Future<Integer> f : futures){
            System.out.println(f.get());
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        testFutureGroup();
    }
}
