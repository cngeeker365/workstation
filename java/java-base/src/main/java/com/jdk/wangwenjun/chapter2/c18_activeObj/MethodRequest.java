package com.jdk.wangwenjun.chapter2.c18_activeObj;

/**
 * 对应 ActiveObject 的每一个方法
 * @author taobaibai
 * @create 2020-04-16 8:31
 */
public abstract class MethodRequest {
    protected final Servant servant;
    protected final FutureResult futureResult;

    public MethodRequest(Servant servant, FutureResult futureResult) {
        this.servant = servant;
        this.futureResult = futureResult;
    }

    public abstract void execute();
}
