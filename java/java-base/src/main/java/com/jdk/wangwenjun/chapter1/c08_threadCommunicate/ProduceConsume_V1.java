package com.jdk.wangwenjun.chapter1.c08_threadCommunicate;

/**
 * @author taobaibai
 * @create 2020-04-12 17:28
 */
public class ProduceConsume_V1 {
    private int i = 0;
    final private Object lock = new Object();
    private void produce(){
        synchronized (lock){
            System.out.println("P->"+(i++));
        }
    }

    private void consume(){
        synchronized (lock){
            System.out.println("C->"+i);
        }
    }

    public static void main(String[] args) {
        ProduceConsume_V1 pc = new ProduceConsume_V1();
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
}
