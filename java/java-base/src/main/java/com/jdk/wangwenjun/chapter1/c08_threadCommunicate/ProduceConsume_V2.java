package com.jdk.wangwenjun.chapter1.c08_threadCommunicate;

import java.util.stream.Stream;

/**
 *
 * @author taobaibai
 * @create 2020-04-12 17:28
 */
public class ProduceConsume_V2 {
    private int i = 0;
    final private Object lock = new Object();
    private volatile boolean isProduced = false;
    private void produce(){
        synchronized (lock){
            if(isProduced){
                try {
                    lock.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                i++;
                System.out.println("P->"+i);
                isProduced = true;
                lock.notify();
            }
        }
    }

    private void consume(){
        synchronized (lock){
            if(isProduced){
                System.out.println("C->"+i);
                lock.notify();
                isProduced = false;
            }else {
                try {
                    lock.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) {
//        singleProduceAndConsumerTest();
        multiProduceAndConsumerTest();
    }

    public static void singleProduceAndConsumerTest(){
        ProduceConsume_V2 pc = new ProduceConsume_V2();
        new Thread(()->{
            while (true){
                pc.produce();
            }
        }, "producer").start();

        new Thread(()->{
            while (true){
                pc.consume();
            }
        },"consumer").start();
    }

    //多个生产者、消费者的情况下会有问题
    public static void multiProduceAndConsumerTest(){
        ProduceConsume_V2 pc = new ProduceConsume_V2();
        Stream.of("P1","P2").forEach( n ->
            new Thread(()->{
                while (true){
                    pc.produce();
                }
            }, n).start()
        );

        Stream.of("C1","C2").forEach( n ->
                new Thread(()->{
                    while (true){
                        pc.consume();
                    }
                },n).start()
        );
    }
}
