package com.jdk.wangwenjun.chapter2.c18_activeObj;

/**
 * @author taobaibai
 * @create 2020-04-16 8:35
 */
public class RealResult implements Result {
    private final Object resultVal;

    public RealResult(Object resultVal) {
        this.resultVal = resultVal;
    }

    @Override
    public Object getResultVal() {
        return this.resultVal;
    }
}
