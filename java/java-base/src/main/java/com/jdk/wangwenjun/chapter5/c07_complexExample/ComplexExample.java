package com.jdk.wangwenjun.chapter5.c07_complexExample;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * @author taobaibai
 * @create 2020-04-21 13:46
 */
public class ComplexExample {
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

    private static Runnable toTask(int i){
        return ()->{
            System.out.printf("The task [%d] will be executed\n",i);
            sleep(10+i*5, TimeUnit.SECONDS);
            System.out.printf("The task [%d] is done.\n",i);
        };
    }

    private static class MyTask implements Callable<Integer>{
        private final Integer value;
        private boolean success = false;

        public MyTask(Integer val) {
            this.value = val;
        }

        @Override
        public Integer call() throws Exception {
            System.out.printf("The Task [%d] will be executed.\n",value);
            sleep((value * 5) + 10, TimeUnit.SECONDS);
            System.out.printf("The Task [%d] done.\n",value);
            success = true;
            return value;
        }

        public boolean isSuccess(){
            return success;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
//        List<Runnable> tasks = IntStream.range(0, 5).boxed().map(ComplexExample::toTask).collect(toList());
//        List<Future<?>> futureList = new ArrayList<>();

//        tasks.forEach(r->futureList.add(service.submit(r)));
//        futureList.get(4).get();
//        futureList.get(3).get();
//        futureList.get(2).get();
//        futureList.get(1).get();
//        futureList.get(0).get();

//        final CompletionService<Object> completionService = new ExecutorCompletionService<>(service);
//        tasks.forEach(r->completionService.submit(Executors.callable(r)));
//        Future<?> future;
//        while ((future = completionService.take())!=null){
//            System.out.println(future.get());
//        }

        List<Callable<Integer>> tasks2 = IntStream.range(0, 5).boxed().map(MyTask::new).collect(toList());
        final CompletionService<Integer> completionService = new ExecutorCompletionService<>(service);
        tasks2.forEach(completionService::submit);
        sleep(12, TimeUnit.SECONDS);
//        service.shutdownNow();
        service.shutdown();
        tasks2.stream().filter(callable -> !((MyTask)callable).isSuccess()).forEach(System.out::println);
    }
}
