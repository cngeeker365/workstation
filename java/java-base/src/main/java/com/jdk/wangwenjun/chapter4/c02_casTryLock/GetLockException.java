package com.jdk.wangwenjun.chapter4.c02_casTryLock;

/**
 * @author taobaibai
 * @create 2020-04-17 15:51
 */
public class GetLockException extends Exception{
    public GetLockException() {
        super();
    }
    public GetLockException(String msg){
        super(msg);
    }
}
