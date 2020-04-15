package com.jdk.wangwenjun.chapter2.c10_threadLocal;

/**
 * @author taobaibai
 * @create 2020-04-15 11:00
 */
public class ThreadLocalSimpleTest {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "Alex";
        }
    };

    //JVM start main thread
    public static void main(String[] args) throws InterruptedException {
//        threadLocal.set("Alex");
        Thread.sleep(1000);
        String value = threadLocal.get();
        System.out.println(value);
    }
}
