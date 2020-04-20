package com.jdk.wangwenjun.chapter5.c03_executorService;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * The demo for class {@link java.util.concurrent.ExecutorService}
 *
 * @author taobaibai
 * @create 2020-04-20 8:53
 */
public class ExecutorServiceShutdownErrorHandle {
    private static void sleep(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * [ Question]  : When invoked the shutdown method, can execute the new runnable?
     * [ Answer ]   : The Executor Service will reject after shutdown.
     * {@link ExecutorService#isShutdown()}
     * {@link ExecutorService#shutdown()}
     */
    private static void isShutDown(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();;
        executorService.execute(()->{
            try {
                sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println(executorService.isShutdown());
        executorService.shutdown();
        System.out.println(executorService.isShutdown());
        executorService.execute(()->System.out.println("I will be executed after shutdown."));
    }

    /**
     * {@link ExecutorService#isTerminated()}
     * {@link ThreadPoolExecutor#isTerminating()} ()}
     */
    private static void isTerminated(){
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(()->{
            sleep(2);
        });
        executorService.shutdown();
        System.out.println(executorService.isShutdown());
        System.out.println(executorService.isTerminated());
        System.out.println(((ThreadPoolExecutor) executorService).isTerminating());
    }

    /**
     * 展示多线程执行过程中遇到异常如何处理
     * @throws InterruptedException
     */
    private static void executeRunnableError() throws InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorService executorService = Executors.newFixedThreadPool(10, new MyThreadFactory());
        executorService.execute(()->{
            sleep(2);
        });
        IntStream.range(0,10).boxed().forEach(i->executorService.execute(()->System.out.println(1/0)));
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.MINUTES);
        System.out.println("=======================================================");
    }
    //该方式常用于在扩展别人方法时使用
    private static class MyThreadFactory implements ThreadFactory{
        private final static AtomicInteger SEQ = new AtomicInteger();

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("My-Thread-"+SEQ.getAndIncrement());
            thread.setUncaughtExceptionHandler((t,cause)->{
                System.out.println("The thread "+t.getName() +" execute failed.");
                System.out.println("**********************************");
            });
            return thread;
        }
    }

    /**
     * 该方式可以较好的处理对多并发执行任务遇到异常时，根据状态进行不同的处理。
     *
     * <pre>
     *                                         +----->
     *                                         +----->
     * send request ---> store DB ---> 10 ---> +----->
     *                                         +----->
     *                                         +----->
     * </pre>
     * @throws InterruptedException
     */
    private static void executeRunnableTask() throws InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorService executorService = Executors.newFixedThreadPool(10, new MyThreadFactory());
        IntStream.range(0,10).boxed().forEach(i->executorService.execute(
                new MyTask(i) {
                    @Override
                    protected void doExecute() {
                        if(i%3==0){
                            int tmp = i/0;
                        }
                    }

                    @Override
                    protected void doInit() {
                        //do nothing
                    }

                    @Override
                    protected void done() {
                        System.out.println("The No-["+i+"] successfully, update status DONE.");
                    }

                    @Override
                    protected void error(Throwable cause) {
                        System.out.println("The No-["+i+"] failed, update status ERROR.");
                    }
                }
        ));
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.MINUTES);
        System.out.println("=======================================================");
    }
    //模板设计模式
    private abstract static class MyTask implements Runnable{
        protected final int no;

        public MyTask(int no) {
            this.no = no;
        }

        @Override
        public void run() {
            try {
                this.doInit();
                this.doExecute();
                this.done();
            } catch (Throwable cause) {
                this.error(cause);
            }
        }

        protected abstract void doExecute();
        protected abstract void doInit();
        protected abstract void done();
        protected abstract void error(Throwable cause);

    }

    public static void main(String[] args) throws Exception {
//        isShutDown();
//        isTerminated();
//        executeRunnableError();
        executeRunnableTask();
    }
}
