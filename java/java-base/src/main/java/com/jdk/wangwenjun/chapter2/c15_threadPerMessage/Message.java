package com.jdk.wangwenjun.chapter2.c15_threadPerMessage;

/**
 * @author taobaibai
 * @create 2020-04-15 15:35
 */
public class Message {
    private final String data;

    public Message(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
