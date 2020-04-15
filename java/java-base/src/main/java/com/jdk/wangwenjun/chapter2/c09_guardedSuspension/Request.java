package com.jdk.wangwenjun.chapter2.c09_guardedSuspension;

/**
 * @author taobaibai
 * @create 2020-04-15 9:50
 */
public class Request {
    final private String value;

    public Request(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
