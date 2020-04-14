package com.jdk.wangwenjun.chapter2.c01_singleton;

import java.util.stream.IntStream;

/**
 *
 * @author taobaibai
 * @create 2020-04-13 22:37
 */
public class Singleton_07 {

    private Singleton_07(){
        //empty
    }

    private enum Singleton{
        INSTANCE;

        private final Singleton_07 instance;

        //枚举的构造函数仅执行一次
        Singleton(){
            instance = new Singleton_07();
        }

        public Singleton_07 getInstance() {
            return instance;
        }
    }

    public static Singleton_07 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100).forEach(i->new Thread(String.valueOf(i)){
            @Override
            public void run() {
                System.out.println(Singleton_07.getInstance());
            }
        }.start());
    }
}
