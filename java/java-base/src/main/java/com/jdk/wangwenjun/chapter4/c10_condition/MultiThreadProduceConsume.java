package com.jdk.wangwenjun.chapter4.c10_condition;

import java.util.LinkedList;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author taobaibai
 * @create 2020-04-18 22:38
 */
public class MultiThreadProduceConsume {
    private final static ReentrantLock lock = new ReentrantLock();
    private final static Condition PRODUCE_COND = lock.newCondition();
    private final static Condition CONSUME_COND = lock.newCondition();
    private final static LinkedList<Long> TIMESTAMP_POOL = new LinkedList<>();
    private final static int MAX_CAPACITY = 100;

    public static void produce(){
        try{
            lock.lock();
            while(TIMESTAMP_POOL.size() >= MAX_CAPACITY){
                PRODUCE_COND.await();
            }
            long value = System.currentTimeMillis();
            Optional.of(Thread.currentThread().getName()+"-P-"+value).ifPresent(System.out::println);
            System.out.println("=====================================================================");
            System.out.println("PRODUCE_COND.getWaitQueueLength => " + lock.getWaitQueueLength(PRODUCE_COND));
            System.out.println("PRODUCE_COND.hasWaiters => " + lock.hasWaiters(PRODUCE_COND));
            System.out.println("=====================================================================");
            TIMESTAMP_POOL.addLast(value);
            CONSUME_COND.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            lock.unlock();
        }
    }

    public static void consume(){
        try{
            lock.lock();
            while (TIMESTAMP_POOL.isEmpty()){
                CONSUME_COND.await();
            }
            long value = TIMESTAMP_POOL.removeFirst();
            Optional.of(Thread.currentThread().getName()+"-C-"+value).ifPresent(System.out::println);
            System.out.println("=====================================================================");
            System.out.println("CONSUME_COND.getWaitQueueLength => " + lock.getWaitQueueLength(CONSUME_COND));
            System.out.println("CONSUME_COND.hasWaiters => " + lock.hasWaiters(CONSUME_COND));
            System.out.println("=====================================================================");
            PRODUCE_COND.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            lock.unlock();
        }
    }

    public static void beginProduce(int i){
        new Thread(()->{
            while(true){
                produce();
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "P-"+i).start();
    }
    public static void beginConsume(int i){
        new Thread(()->{
            while(true){
                consume();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C-"+i).start();
    }
    public static void main(String[] args) throws InterruptedException {
        IntStream.range(0,6).boxed().forEach(MultiThreadProduceConsume::beginProduce);
        IntStream.range(0,6).boxed().forEach(MultiThreadProduceConsume::beginConsume);
    }
}
