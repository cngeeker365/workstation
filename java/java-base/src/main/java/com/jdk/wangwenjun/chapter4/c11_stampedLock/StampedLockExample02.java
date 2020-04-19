package com.jdk.wangwenjun.chapter4.c11_stampedLock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.Collectors;

/**
 * @author taobaibai
 * @create 2020-04-19 11:33
 */
public class StampedLockExample02 {
    private final static StampedLock lock = new StampedLock();
    private final static List<Long> DATA = new ArrayList<>();

    private static void read(){
        //拿乐观锁
        long stamped = lock.tryOptimisticRead();
        //验证锁情况
        if(lock.validate(stamped)){
            try{
                stamped = lock.readLock();
                Optional.of(DATA.stream().map(String::valueOf).collect(Collectors.joining("#", "R-", ""))).ifPresent(System.out::println);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally{
                lock.unlockRead(stamped);
            }

        }
    }

    private static void write(){
        long stamped = -1;
        try {
            stamped = lock.writeLock();
            DATA.add(System.currentTimeMillis());
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlockWrite(stamped);
        }
    }

    public static void main(String[] args) {
        final ExecutorService executor = Executors.newFixedThreadPool(10);
        Runnable readTask = ()->{
            for(;;){
                read();
            }
        };
        Runnable writeTask = ()->{
            for(;;){
                write();
            }
        };
        executor.submit(readTask);
        executor.submit(readTask);
        executor.submit(readTask);
        executor.submit(readTask);
        executor.submit(readTask);
        executor.submit(readTask);
        executor.submit(readTask);
        executor.submit(readTask);
        executor.submit(readTask);
        executor.submit(writeTask);
    }
}
