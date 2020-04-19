package com.jdk.wangwenjun.chapter4.c12_forkJoin;

import java.util.Optional;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author taobaibai
 * @create 2020-04-19 13:56
 */
public class ForkJoinRecursiveAction {
    private final static int MAX_THRESHOLD = 3;
    private final static AtomicInteger SUM = new AtomicInteger();
    private static class CalculateRecursiveAction extends RecursiveAction{
        private final int start;
        private final int end;

        public CalculateRecursiveAction(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if(end-start <= MAX_THRESHOLD){
                SUM.addAndGet(IntStream.rangeClosed(start, end).sum());
            }else {
                int middle = (start+end)/2;
                CalculateRecursiveAction leftAction = new CalculateRecursiveAction(start, middle);
                CalculateRecursiveAction rightAction = new CalculateRecursiveAction(middle+1, end);
                leftAction.fork();
                rightAction.fork();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(new CalculateRecursiveAction(0, 100));
        forkJoinPool.awaitTermination(10, TimeUnit.SECONDS);
        Optional.of(SUM).ifPresent(System.out::println);
    }
}
