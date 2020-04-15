package com.jdk.wangwenjun.chapter2.c15_threadPerMessage;

import java.util.stream.IntStream;

/**
 * @author taobaibai
 * @create 2020-04-15 16:39
 */
public class PerThreadClient {
    public static void main(String[] args) {
        MessageHandler handler = new MessageHandler();
        IntStream.rangeClosed(0,10).forEach(i->{
            handler.request(new Message(String.valueOf(i)));
        });
        handler.shutdown();
    }
}
