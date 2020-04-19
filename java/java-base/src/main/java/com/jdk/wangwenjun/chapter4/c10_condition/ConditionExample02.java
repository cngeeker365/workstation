package com.jdk.wangwenjun.chapter4.c10_condition;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author taobaibai
 * @create 2020-04-18 22:38
 */
public class ConditionExample02 {
    private final static ReentrantLock lock = new ReentrantLock(true);
    private final static Condition condition = lock.newCondition();
    private static int data = 0;
    private static volatile boolean noUse = true;

    /**
     * 1. not use the Condition, only use the Lock?
     *      No.
     * 2. not use the Lock, only use the Condition?
     *      No.
     * 3. the producer get the lock but invoke await() and not jump out the lock statement block.
     *    why the Consumer can get the lock still?
     */
    public static void buildData(){
        try{
            lock.lock();            //等价于 synchronized(key) #monitor entor
//            while(noUse){
//                condition.await();  //monitor.wait()
//            }
            data++;
            Optional.of("Producer: "+data).ifPresent(System.out::println);
            TimeUnit.SECONDS.sleep(1);
//            noUse = true;
//            condition.signal();     //monitor.notify()
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            lock.unlock();          //synchronized end #monitor end
        }
    }

    public static void useData(){
        try{
            lock.lock();
//            while (!noUse){
//                condition.await();
//            }
            TimeUnit.SECONDS.sleep(1);
            Optional.of("Consumer: "+data).ifPresent(System.out::println);
//            noUse = false;
//            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(()->{
            while(true){
                buildData();
            }
        }).start();
        new Thread(()->{
            while(true){
                useData();
            }
        }).start();
    }
}
