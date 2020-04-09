package com.jdk.highLevel.wangwenjun.concurrency.chapter1;

/**
 * @author taobaibai
 * @create 2020-04-09 12:02
 */
public class TryCurrency_01 {
    public static void main(String[] args) {
        new Thread(()->readFromDB()).start();
        new Thread(()->writeIntoDB()).start();

    }

    public static void readFromDB(){
        try {
            System.out.println("Read Start");
            Thread.sleep(1000L);
            System.out.println("Read Finsh");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void writeIntoDB(){
        try {
            System.out.println("Write Start");
            Thread.sleep(1000L);
            System.out.println("Write Finsh");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
