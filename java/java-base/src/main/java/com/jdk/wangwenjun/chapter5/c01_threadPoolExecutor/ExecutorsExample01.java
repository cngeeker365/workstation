package com.jdk.wangwenjun.chapter5.c01_threadPoolExecutor;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * @author taobaibai
 * @create 2020-04-19 20:03
 */
public class ExecutorsExample01 {

    private static void sleep(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * These pools will typically improve the performance
     * of programs that execute many short-lived asynchronous tasks.
     * <p>
     * return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
     * 60L, TimeUnit.SECONDS,
     * new SynchronousQueue<Runnable>());
     */
    public static void useCachedThreadPool() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println(((ThreadPoolExecutor) executorService).getActiveCount());

        executorService.execute(() -> System.out.println("====================="));
        System.out.println(((ThreadPoolExecutor) executorService).getActiveCount());

        IntStream.range(0, 100).boxed().forEach(i -> executorService.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "[" + i + "]");
        }));
        TimeUnit.SECONDS.sleep(1);
        System.out.println(((ThreadPoolExecutor) executorService).getActiveCount());
    }

    /**
     * return new ThreadPoolExecutor(nThreads, nThreads,
     * 0L, TimeUnit.MILLISECONDS,
     * new LinkedBlockingQueue<Runnable>());
     *
     * @throws Exception
     */
    public static void useFixedSizePool() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        IntStream.range(0, 100).boxed().forEach(i -> executorService.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "[" + i + "]");
        }));
        TimeUnit.SECONDS.sleep(1);
        System.out.println(((ThreadPoolExecutor) executorService).getActiveCount());
    }

    /**
     * SingleThreadExecutor VS. oneThread
     * [1] Thread will die after finish work, but SingleThreadExecutor can always alive.
     * [2] Thread don't have cache queue for the submitted runnable, but SingleThreadExecutor have.
     */
    public static void useSinglePool() throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        IntStream.range(0, 100).boxed().forEach(i -> executorService.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "[" + i + "]");
        }));
        TimeUnit.SECONDS.sleep(1);
        //不是 ThreadPoolExecutor 的子类，不能转换
//        System.out.println(((ThreadPoolExecutor) executorService).getActiveCount());
    }

    /**
     * return new ForkJoinPool (Runtime.getRuntime().availableProcessors(),     ## CPU核数
     * ForkJoinPool.defaultForkJoinWorkerThreadFactory,
     * null, true);
     *
     * @throws Exception
     */
    public static void useWorkStealingPool() throws Exception {
        ExecutorService executorService = Executors.newWorkStealingPool();

        List<Callable<String>> callableList = IntStream.range(0, 20).boxed().map(i -> (Callable<String>) () -> {
                    System.out.println("Thread " + Thread.currentThread().getName());
                    sleep(2);
                    return "Task-" + i;
                }
        ).collect(toList());

        List<Future<String>> futures = executorService.invokeAll(callableList);
        futures.stream().map(future -> {
            try {
                return future.get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).forEach(System.out::println);
    }


    public static void main(String[] args) throws Exception {
//        useFixedSizePool();
//        useSinglePool();
        useWorkStealingPool();
    }

}
