package com.jdk.wangwenjun.chapter5.c03_executorService;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * 线程池因子：
 * 自定义线程池                  JDK线程池
 * [1] init
 * [2] active
 * [3] max
 * [4] queue
 * [5] rejectPolicy
 * [6] retrievePolicy
 *
 * @author taobaibai
 * @create 2020-04-20 8:53
 */
public class ExecutorServiceAPI {
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

    public static void test() {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        System.out.println(executorService.getActiveCount());
        executorService.execute(() -> {
            sleep(10, TimeUnit.SECONDS);
        });
        sleep(20, TimeUnit.MILLISECONDS);
        System.out.println(executorService.getActiveCount());
    }

    /**
     * 设置线程可在多久后被回收
     */
    public static void testAllowCoreThreadTimeOut() {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        executorService.setKeepAliveTime(10, TimeUnit.SECONDS);
        executorService.allowCoreThreadTimeOut(true);

        IntStream.range(0, 5).boxed().forEach(i -> {
            executorService.execute(() -> {
                sleep(3, TimeUnit.SECONDS);
            });
        });
    }

    public static void testRemove() {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        executorService.setKeepAliveTime(10, TimeUnit.SECONDS);
        executorService.allowCoreThreadTimeOut(true);

        IntStream.range(0, 2).boxed().forEach(i -> {
            executorService.execute(() -> {
                sleep(5, TimeUnit.SECONDS);
                System.out.println("[" + i + "] =========== I am finished.");
            });
        });
        sleep(200, TimeUnit.MILLISECONDS);
        Runnable r = () -> {
            System.out.println("I will never be executed!");
        };
        executorService.execute(r);
//        sleep(5, TimeUnit.MILLISECONDS);
        executorService.remove(r);
    }

    public static void testPreStartCoreThread() {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        System.out.println(executorService.getActiveCount());

        System.out.println(executorService.prestartCoreThread());
        System.out.println(executorService.getActiveCount());

        System.out.println(executorService.prestartCoreThread());
        System.out.println(executorService.getActiveCount());
        executorService.execute(() -> sleep(1, TimeUnit.SECONDS));
        executorService.execute(() -> sleep(1, TimeUnit.SECONDS));

        System.out.println(executorService.prestartCoreThread());
        System.out.println(executorService.getActiveCount());

    }

    public static void testPreStartAllThread() {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        executorService.setMaximumPoolSize(3);
        System.out.println(executorService.getActiveCount());

        System.out.println(executorService.prestartAllCoreThreads());
        System.out.println(executorService.prestartCoreThread());
        System.out.println(executorService.getActiveCount());

        System.out.println(executorService.prestartCoreThread());
        System.out.println(executorService.getActiveCount());

    }

    public static void testThreadPoolAdvice() {
        ThreadPoolExecutor executorService = new MyThreadPoolExecutor(1, 2, 30, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                r -> {
                    Thread t = new Thread(r);
                    return t;
                }, new ThreadPoolExecutor.AbortPolicy());
        executorService.execute(new MyRunnable(1) {
            @Override
            public void run() {
//                System.out.println("=================================");
                System.out.println(1 / 0);
            }
        });
    }

    private abstract static class MyRunnable implements Runnable {
        private final int no;

        protected MyRunnable(int no) {
            this.no = no;
        }

        protected int getData() {
            return this.no;
        }
    }

    private static class MyThreadPoolExecutor extends ThreadPoolExecutor {
        public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
        }

        @Override
        protected void beforeExecute(Thread t, Runnable r) {
            System.out.println("init the " + ((MyRunnable) r).getData());
        }

        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            if (null == t) {
                System.out.println("successful " + ((MyRunnable) r).getData());
            } else {
//                t.printStackTrace();
                System.out.println("Something Bad happened.");
            }
        }
    }

    /**
     * [ Question ] :   When the result returned, other callable will be kept on process?
     * [ Answer ]   :   Other callable will be canceled, But I did get this result.
     * [ Note ]     :   The invokeAny will be blocked caller.
     * {@link ExecutorService#invokeAny(Collection)}
     */
    private static void testInvokeAny() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Callable<Integer>> callableList = IntStream.range(0, 5).boxed().map(i -> (Callable<Integer>) () -> {
            sleep(ThreadLocalRandom.current().nextInt(20), TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getName() + " : " + i);
            return i;
        }).collect(toList());
        Integer val = executorService.invokeAny(callableList);
        System.out.println("======================finished=======================");
        System.out.println(val);
    }

    private static void testInvokeAnyTimeOut() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Integer val = executorService.invokeAny(
                IntStream.range(0, 5).boxed().map(i -> (Callable<Integer>) () -> {
                    sleep(ThreadLocalRandom.current().nextInt(1000), TimeUnit.SECONDS);
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                    return i;
                }).collect(toList()), 1, TimeUnit.SECONDS);

        System.out.println("======================finished=======================");
        System.out.println(val);
    }

    /**
     * RxJava
     * @throws Exception
     */
    private static void testInvokeAll() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.invokeAll(
                IntStream.range(0, 5).boxed().map(i -> (Callable<Integer>) () -> {
                    sleep(ThreadLocalRandom.current().nextInt(10), TimeUnit.SECONDS);
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                    return i;
                }).collect(toList())
        ).parallelStream().map(future -> {
            try {
                return future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }).forEach(System.out::println);

        System.out.println("======================finished=======================");
    }

    private static void testInvokeAllTimeOut() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.invokeAll(
                IntStream.range(0, 5).boxed().map(i -> (Callable<Integer>) () -> {
                    sleep(ThreadLocalRandom.current().nextInt(10), TimeUnit.SECONDS);
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                    return i;
                }).collect(toList()), 1, TimeUnit.SECONDS
        ).parallelStream().map(future -> {
            try {
                return future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }).forEach(System.out::println);

        System.out.println("======================finished=======================");
    }

    /**
     * invoke / execute / submit 执行某个任务时，会触发线程池线程的创建，来处理任务；
     * 直接在 Queue 中添加任务，不会触发创建线程，只能等待已有线程。
     * {@link ExecutorService#submit(Runnable)}
     * @throws Exception
     */
    private static void testSubmit() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<?> future =executorService.submit(()->{
            sleep(3, TimeUnit.SECONDS);
        });
        Object nil = future.get();
        System.out.println("R: "+nil);
    }

    public static void testAddQueueDirectly() {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        executorService.execute(()->System.out.println("I will be process because of triggered the execute."));
        executorService.getQueue().add(()-> System.out.println("I am added directly into the queue."));
    }

    private static void testSubmitRunnableWithResult() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        String result = "Done";
        Future<String> future =executorService.submit(()->{
            sleep(3, TimeUnit.SECONDS);
        }, result);
        Object nil = future.get();
        System.out.println("R: "+nil);
    }

    public static void main(String[] args) throws Exception {
//        test();
//        testAllowCoreThreadTimeOut();
//        testRemove();
//        testPreStartCoreThread();
//        testPreStartAllThread();
//        testThreadPoolAdvice();
//        testInvokeAny();
//        testInvokeAnyTimeOut();
//        testInvokeAll();
//        testInvokeAllTimeOut();
//        testSubmit();
        testSubmitRunnableWithResult();
    }


}
