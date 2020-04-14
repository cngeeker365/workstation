package com.jdk.wangwenjun.chapter1.c09_myLockDefine;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author taobaibai
 * @create 2020-04-12 20:53
 */
public class LockTest {
    public static void main(String[] args) throws InterruptedException {
        final BooleanBlock booleanBlock = new BooleanBlock();
        Stream.of("T1","T2","T3","T4").forEach(name->{
            new Thread(()->{
                try {
                    booleanBlock.lock(10L);
                    Optional.of(Thread.currentThread().getName()+" have the lock monitor.").ifPresent(System.out::println);
                    work();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Lock.TimeOutException e){
                    Optional.of(Thread.currentThread().getName()+" time out.").ifPresent(System.out::println);
                } finally {
                    booleanBlock.unlock();
                }
            }, name).start();
        });
        Thread.sleep(100);
        //谁加锁，谁释放，这里不起作用
        booleanBlock.unlock();
    }

    private static void work() throws InterruptedException {
        Optional.of(Thread.currentThread().getName()+" is working...").ifPresent(System.out::println);
        Thread.sleep(10_000);
    }
}
