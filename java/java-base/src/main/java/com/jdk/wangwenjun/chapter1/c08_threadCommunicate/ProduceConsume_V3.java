package com.jdk.wangwenjun.chapter1.c08_threadCommunicate;

import java.util.stream.Stream;

/**
 * @author taobaibai
 * @create 2020-04-12 17:28
 */
public class ProduceConsume_V3 {
    private int i = 0;
    final private Object lock = new Object();
    private volatile boolean isProduced = false;

    private void produce() {
        synchronized (lock) {
            //此处一定要用 while，因为可能有一个生产者已经进入了判断是否生产，如果不用while，就会跳过if判断，导致重复生产
            while (isProduced) {
                try {
                    lock.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            i++;
            System.out.println(Thread.currentThread().getName() + "->" + i);
            isProduced = true;
            lock.notifyAll();
        }
    }

    private void consume() {
        synchronized (lock) {
            while (!isProduced){
                try {
                    lock.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "->" + i);
            lock.notifyAll();
            isProduced = false;
        }
    }

    public static void main(String[] args) {
        multiProduceAndConsumerTest();
    }

    //多个生产者、消费者的情况下会有问题
    public static void multiProduceAndConsumerTest() {
        ProduceConsume_V3 pc = new ProduceConsume_V3();
        Stream.of("P1", "P2").forEach(n ->
                new Thread(() -> {
                    while (true) {
                        pc.produce();
                    }
                }, n).start()
        );

        Stream.of("C1", "C2").forEach(n ->
                new Thread(() -> {
                    while (true) {
                        pc.consume();
                    }
                }, n).start()
        );
    }
}
