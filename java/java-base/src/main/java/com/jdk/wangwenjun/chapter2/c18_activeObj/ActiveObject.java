package com.jdk.wangwenjun.chapter2.c18_activeObj;

/**
 * 接收异步消息的主动对象
 * @author taobaibai
 * @create 2020-04-16 8:24
 */
public interface ActiveObject {
    Result makeString(int count, char fillChar);
    void displayString(String text);
}
