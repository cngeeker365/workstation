package com.jdk.wangwenjun.chapter1.c05_simpleAPI;

/**
 * @author taobaibai
 * @create 2020-04-12 14:10
 */
public class SimpleAPI_04_interrupt {
    private static final Object MONITOR = new Object();
    public static void main(String[] args) throws InterruptedException {


    }

    public static void test_01() throws InterruptedException {
        Thread t = new Thread(()->{
            while (true){
                synchronized (MONITOR){
                    try {
                        MONITOR.wait(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
//                        System.out.println(Thread.currentThread().isInterrupted());
                        System.out.println(Thread.interrupted());
                    }
                }
            }
        }, "t1");
        t.start();

        Thread.sleep(100);
        System.out.println(t.isInterrupted());
        t.interrupt();
        System.out.println(t.isInterrupted());
    }

    public static void test_02() throws InterruptedException{
        Thread main = Thread.currentThread();

        Thread t1 = new Thread(){
            @Override
            public void run() {
                while (true){

                }
            }
        };
        t1.start();

        Thread t2 = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                main.interrupt();
                System.out.println("main interrupt");
            }
        };
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
