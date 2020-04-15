package com.jdk.wangwenjun.chapter2.c11_context.threadLocalCtx;

/**
 * @author taobaibai
 * @create 2020-04-15 11:21
 */
public class Context {
    private String name;
    private String cardID;

    public void setName(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String getCardID() {
        return cardID;
    }
}
