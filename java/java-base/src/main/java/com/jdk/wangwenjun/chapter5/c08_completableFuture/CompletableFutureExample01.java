package com.jdk.wangwenjun.chapter5.c08_completableFuture;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * @author taobaibai
 * @create 2020-04-21 15:49
 */
public class CompletableFutureExample01 {
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
     * Future：等待任务全部完成，才能拿值，不能一个完成就拿一个
     */
    public static void test1() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<?> future = executorService.submit(() -> {
            sleep(10, TimeUnit.SECONDS);
        });
        while (!future.isDone()) {

        }
        System.out.println("Done.");
    }

    public static int get() {
        int value = ThreadLocalRandom.current().nextInt(20);
        System.out.println(Thread.currentThread().getName() + " get will be sleep " + value);
        sleep(value, TimeUnit.SECONDS);
        System.out.println(Thread.currentThread().getName() + " get done " + value);
        return value;
    }

    public static void display(int data) {
        int value = ThreadLocalRandom.current().nextInt(20);
        System.out.println(Thread.currentThread().getName() + " display will be sleep " + value);
        sleep(value, TimeUnit.SECONDS);
        System.out.println(Thread.currentThread().getName() + " display done " + value);
    }

    /**
     * 不能做到一个完成get立马就display
     *
     * @throws InterruptedException
     */
    public static void test3() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Callable<Integer>> tasks = IntStream.range(0, 10).boxed().map(i -> (Callable<Integer>) () -> get()).collect(toList());
        executorService.invokeAll(tasks).stream().map(future -> {
            try {
                return future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }).parallel().forEach(CompletableFutureExample01::display);
    }

    /**
     * 完成一个get，立刻做display
     *
     * @throws InterruptedException
     */
    public static void test4() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.range(0, 10).boxed()
                .forEach(i -> CompletableFuture.supplyAsync(CompletableFutureExample01::get, executorService)
                        .thenAccept(CompletableFutureExample01::display)
                        .whenComplete((v, t) -> System.out.println(i + " Done.")));
        Thread.currentThread().join();
    }

    public static void testSupplyAsync() throws InterruptedException {
        CompletableFuture.supplyAsync(Object::new)
                .thenAcceptAsync(o -> {
                    System.out.println("Obj=============Start");
                    sleep(5, TimeUnit.SECONDS);
                    System.out.println("Obj=============" + o);
                }).runAfterBoth(
                CompletableFuture.supplyAsync(() -> "Hello")
                        .thenAcceptAsync(s -> {
                            System.out.println("String============Start");
                            sleep(3, TimeUnit.SECONDS);
                            System.out.println("String============" + s);
                        }), () -> System.out.println("=====Finish====="));
        Thread.currentThread().join();
    }

    public static void testRunAsync() throws InterruptedException, ExecutionException {
        Future<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Obj=============Start");
            sleep(5, TimeUnit.SECONDS);
            System.out.println("Obj=============End");
        }).whenComplete((v, t) -> System.out.println("Done"));
        System.out.println("=============I am not blocked.=============");
        System.out.println(future.get());
        Thread.currentThread().join();
    }

    public static void testCompleted() throws Exception {
        Future<Void> future = CompletableFuture.completedFuture("Hello").thenAccept(System.out::println);
        System.out.println(future.isDone());
        Thread.currentThread().join();
    }

    public static void testAnyOf() throws Exception {
        Future<?> future = CompletableFuture.anyOf(
                CompletableFuture.runAsync(
                        () -> {
                                    System.out.println("1====================Start");
                                    sleep(5, TimeUnit.SECONDS);
                                    System.out.println("1====================End");
                        }
                ).whenComplete(
                        (v, t) -> System.out.println("===================Over1==================")),
                        CompletableFuture.supplyAsync(
                                () -> {
                                            System.out.println("2====================Start");
                                            sleep(4, TimeUnit.SECONDS);
                                            System.out.println("2====================End");
                                            return "Hello";
                                }
                        )
        ).whenComplete((v,t) -> System.out.println("==================="+v+"=================="));

        System.out.println(">>>>>>>>>>"+future.get());
        Thread.currentThread().join();
    }

    public static void main(String[] args) throws Exception {
//        test4();
//        testRunAsync();
//        testCompleted();
        testAnyOf();
    }
}
