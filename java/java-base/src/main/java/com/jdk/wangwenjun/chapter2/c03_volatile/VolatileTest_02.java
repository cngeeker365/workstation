package com.jdk.wangwenjun.chapter2.c03_volatile;

/**
 * @author taobaibai
 * @create 2020-04-14 11:01
 */
public class VolatileTest_02 {
    private static int INIT_VAL = 0;
//    private static volatile int INIT_VAL = 0;
    private final static int MAX_LIMIT = 50;

    public static void main(String[] args) throws Exception{
        new Thread(() -> {
            while (INIT_VAL < MAX_LIMIT) {
                /**
                 * 不保证原子性，以下 3 步可中断：
                 *      1. read from main memory INIT_VAL -> 10
                 *      2. INIT_VAL = 10 + 1
                 *      3. INIT_VAL = 11
                 */
                System.out.println("T1-->"+(++INIT_VAL));
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "ADDER-01").start();

        new Thread(() -> {
            while (INIT_VAL < MAX_LIMIT) {
                System.out.println("T2-->"+(++INIT_VAL));
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "ADDER-02").start();
    }
}
