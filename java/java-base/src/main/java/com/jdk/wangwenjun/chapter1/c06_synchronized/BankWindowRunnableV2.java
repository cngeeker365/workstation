package com.jdk.wangwenjun.chapter1.c06_synchronized;

/**
 * @author taobaibai
 * @create 2020-04-09 23:17
 */
public class BankWindowRunnableV2 implements Runnable {
    //可读写的共享数据
    private int index = 1;
    //只读的共享数据
    private final static int MAX = 500;

//    private final Object MONITOR = new Object();
//    @Override
//    public void run() {
//        while (true){
//            synchronized (MONITOR){
//                if(index > MAX) {
//                    break;
//                }
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName()+"==>"+(index++));
//            }
//        }
//    }

    private synchronized boolean ticket(){
        //1. getField ：拷贝index到线程内，过程中可能会被修改，需加锁
        if(index>MAX){
            return true;
        }
        try {
            Thread.sleep(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //2. index++ ==> index=index+1
        //2.1 get Field index
        //2.2 index = index + 1
        //2.3 put field index
        System.out.println(Thread.currentThread().getName() + "--->" + (index++));
        return false;
    }

    @Override
    public void run() {
        while (true){
            if(ticket()){
                break;
            }
        }
    }
}
