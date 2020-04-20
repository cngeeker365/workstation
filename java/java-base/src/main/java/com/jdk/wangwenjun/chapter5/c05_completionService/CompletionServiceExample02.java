package com.jdk.wangwenjun.chapter5.c05_completionService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author taobaibai
 * @create 2020-04-20 22:15
 */
public class CompletionServiceExample02 {
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

    private static void test() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
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
        ExecutorCompletionService<Integer> completionService = new ExecutorCompletionService<>(executor);
        List<Future<Integer>> futures = new ArrayList<>();
        callableList.stream().forEach(callable -> futures.add(completionService.submit(callable)));

        /** 方式一 */
        Future<Integer> future = null;
        while ((future = completionService.take()) != null){
            System.out.println(future.get());
        }

        /** 方式二: poll 不阻塞，会报错 */
//        Future<Integer> future = completionService.poll();
//        System.out.println(future.get());

        /** 方式三：poll 等待一定时间，未拿到也报错 */
//        System.out.println(completionService.poll(11, TimeUnit.SECONDS).get());
    }

    private static class Event {
        final private int eventId;
        private String result;

        public Event(int eventId) {
            this.eventId = eventId;
        }

        public int getEventId() {
            return eventId;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }
    private static class MyTask implements Runnable{
        private final Event event;

        public MyTask(Event event) {
            this.event = event;
        }

        @Override
        public void run() {
            sleep(10, TimeUnit.SECONDS);
            event.setResult("I AM SUCCESSFULLY.");
        }
    }
    private static void testEvent() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        ExecutorCompletionService<Event> completionService = new ExecutorCompletionService<>(executor);
        final Event event = new Event(1);
        completionService.submit(new MyTask(event), event);
        System.out.println(completionService.take().get().result);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        test();
        testEvent();
    }
}
