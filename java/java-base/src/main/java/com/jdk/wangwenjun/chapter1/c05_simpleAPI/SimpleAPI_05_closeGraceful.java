package com.jdk.wangwenjun.chapter1.c05_simpleAPI;

/**
 * 采用优雅的方式结束线程生命周期
 *      1) 通过开关
 *      2）通过 interrupt 方法触发
 * @author taobaibai
 * @create 2020-04-12 14:36
 */
public class SimpleAPI_05_closeGraceful {
    public static void main(String[] args) {
        testWorker02();
    }

    /**
     * 通过开关
     */
    private static class Worker01 extends Thread{
        private volatile boolean start = true;

        @Override
        public void run() {
            while (true){

            }
        }
        public void shutdown(){
            this.start = false;
        }
    }
    public static void testWorker01(){
        Worker01 worker = new Worker01();
        worker.start();
        try {
            Thread.sleep(10_000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        worker.shutdown();
    }

    /**
     * 通过 interrupt 方法触发
     */
    private static class Worker02 extends Thread{
        @Override
        public void run() {
            while (true){
                if(Thread.interrupted()) {
                    break;
                }
            }
            //------other options------
        }
    }
    public static void testWorker02(){
        Worker02 worker = new Worker02();
        worker.start();
        try {
            Thread.sleep(10_000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        worker.interrupt();
    }

    /**
     * 强制关闭
     */
    private static class Worker03 extends Thread{
        @Override
        public void run() {
            //connection
            //thread blocked & no flag & nowhere to interrupt
        }
    }
    public static void testWorker03(){
        Worker02 worker = new Worker02();
        worker.start();
        try {
            Thread.sleep(10_000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        worker.interrupt();
    }
}
