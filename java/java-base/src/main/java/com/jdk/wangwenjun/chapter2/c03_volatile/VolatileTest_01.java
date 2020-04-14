package com.jdk.wangwenjun.chapter2.c03_volatile;

/**
 * @author taobaibai
 * @create 2020-04-14 11:01
 */
public class VolatileTest_01 {
    private volatile static int INIT_VAL = 0;
    private volatile static int MAX_LIMIT = 50;

    public static void main(String[] args) throws Exception{
        new Thread(() -> {
            int localVal = INIT_VAL;
            while (localVal < MAX_LIMIT) {
                if (localVal != INIT_VAL) {
                    System.out.printf("The value updated to [%d] \n", INIT_VAL);
                    localVal = INIT_VAL;
                }
            }
        }, "READER").start();

        new Thread(() -> {
            int localVal = INIT_VAL;
            while (localVal < MAX_LIMIT) {
                System.out.printf("Update the value to [%d] \n", ++localVal);
                INIT_VAL = localVal;
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "UPDATER").start();

    }
}
