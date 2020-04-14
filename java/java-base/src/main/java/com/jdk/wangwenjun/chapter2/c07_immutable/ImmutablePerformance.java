package com.jdk.wangwenjun.chapter2.c07_immutable;

/**
 * @author taobaibai
 * @create 2020-04-14 20:24
 */
public class ImmutablePerformance {
    public static void main(String[] args) throws Exception{
        //64935
        syncObjPerformTest();
        //64686
        immutableObjPerformTest();
    }

    public static void syncObjPerformTest() throws Exception{
        long startTimestamp = System.currentTimeMillis();
        SyncObj syncObj = new SyncObj();
        syncObj.setName("Alex");
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for(long l = 0L; l < 10000000; l++){
                    System.out.println(Thread.currentThread().getName() + "===>" +syncObj.toString());
                }
            }
        };
        t1.start();
        t1.join();

        Thread t2 = new Thread(){
            @Override
            public void run() {
                for(long l = 0L; l < 10000000; l++){
                    System.out.println(Thread.currentThread().getName() + "===>" +syncObj.toString());
                }
            }
        };
        t2.start();
        t2.join();
        long endTimestamp = System.currentTimeMillis();
        System.out.println("SyncObj Elapsed time : "+(endTimestamp - startTimestamp));
    }

    public static void immutableObjPerformTest() throws Exception{
        long startTimestamp = System.currentTimeMillis();
        ImmutableObj immutableObj = new ImmutableObj("Alex");
        Thread t1 = new Thread(){
                @Override
                public void run() {
                    for(long l = 0L; l < 10000000; l++){
                        System.out.println(Thread.currentThread().getName() + "===>" +immutableObj.toString());
                    }
                }
            };
        t1.start();
        t1.join();

        Thread t2 = new Thread(){
            @Override
            public void run() {
                for(long l = 0L; l < 10000000; l++){
                    System.out.println(Thread.currentThread().getName() + "===>" +immutableObj.toString());
                }
            }
        };
        t2.start();
        t2.join();

        long endTimestamp = System.currentTimeMillis();
        System.out.println("SyncObj Elapsed time : "+(endTimestamp - startTimestamp));
    }
}

final class ImmutableObj {
    private final String name;

    public ImmutableObj(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "["+name+"]";
    }
}

class SyncObj{
    private String name;

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    @Override
    public synchronized String toString() {
        return "["+name+"]";
    }
}
