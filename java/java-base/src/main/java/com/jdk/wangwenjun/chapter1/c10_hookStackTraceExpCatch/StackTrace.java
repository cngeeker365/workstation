package com.jdk.wangwenjun.chapter1.c10_hookAndThreadExceptionCatch;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author taobaibai
 * @create 2020-04-12 22:18
 */
public class StackTrace {
    public static void main(String[] args) {
        new Test1().test();
    }
}

class Test1 {
    private Test2 test2 = new Test2();
    public void test(){
        test2.test();
    }
}

class Test2 {
    public void test(){
        Arrays.asList(Thread.currentThread().getStackTrace()).stream()
                .filter(e->!e.isNativeMethod())
                .forEach(e-> Optional.of(e.getClassName()+":"+e.getMethodName()+":"+e.getLineNumber()).ifPresent(System.out::println));
    }
}
