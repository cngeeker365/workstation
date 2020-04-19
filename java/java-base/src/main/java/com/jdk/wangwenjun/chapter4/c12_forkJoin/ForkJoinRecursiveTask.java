package com.jdk.wangwenjun.chapter4.c12_forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

/**
 * @author taobaibai
 * @create 2020-04-19 13:43
 */
public class ForkJoinRecursiveTask {
    private final static int MAX_THRESHOLD = 200;
    private static class CalculateRecursiveTask extends RecursiveTask<Integer>{
        private final int start;
        private final int end;

        public CalculateRecursiveTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if(end-start <= MAX_THRESHOLD){
                return IntStream.rangeClosed(start, end).sum();
            }else {
                int middle = (start+end)/2;
                CalculateRecursiveTask leftTask = new CalculateRecursiveTask(start, middle);
                CalculateRecursiveTask rightTask = new CalculateRecursiveTask(middle+1, end);
                leftTask.fork();
                rightTask.fork();
                return leftTask.join()+rightTask.join();
            }
        }
    }

    public static void main(String[] args) {
        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> future = forkJoinPool.submit(new CalculateRecursiveTask(0, 100));
        try {
            Integer result = future.get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
