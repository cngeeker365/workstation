package com.jdk.wangwenjun.chapter2.c11_context.threadLocalCtx;

import java.util.stream.IntStream;

/**
 * @author taobaibai
 * @create 2020-04-15 11:32
 */
public class ContextTest {
    public static void main(String[] args) {
        IntStream.range(1,5).forEach(i->{
            new Thread(new ExecutionTask()).start();
        });
    }
}
