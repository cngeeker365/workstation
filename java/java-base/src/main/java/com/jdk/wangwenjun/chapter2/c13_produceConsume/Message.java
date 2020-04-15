package com.jdk.wangwenjun.chapter2.c13_produceConsume;

/**
 * @author taobaibai
 * @create 2020-04-15 15:35
 */
public class Message {
    private String data;

    public Message(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
