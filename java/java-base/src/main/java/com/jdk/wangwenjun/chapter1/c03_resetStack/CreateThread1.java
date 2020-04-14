package com.jdk.highLevel.wangwenjun.concurrency.chapter1;

/**
 * @author taobaibai
 * @create 2020-04-09 22:54
 */
public class CreateThread1 {
    private static int counter = 0;

    public static void defaultStack(){
        Thread t1 = new Thread(null, new Runnable(){
            @Override
            public void run() {
                try {
                    add(1);
                } catch (Exception e) {
                    System.out.println(counter);
                }
            }
            private void add(int i){
                System.out.println(counter++);
                add(i+1);
            }
        }, "defaultStack Thread");
        t1.start();
    }

    public static void resetStack() {
        Thread t1 = new Thread(null, new Runnable(){
            @Override
            public void run() {
                try {
                    add(1);
                } catch (Exception e) {
                    System.out.println(counter);
                }
            }
            private void add(int i){
                System.out.println(counter++);
                add(i+1);
            }
        }, "resetStack Thread", 1<<24);
        t1.start();
    }

    //JVM will create a thread name "main"
    public static void main(String[] args) {
        defaultStack();
//        resetStack();
    }
}
