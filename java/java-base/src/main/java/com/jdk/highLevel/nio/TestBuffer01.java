package com.jdk.highLevel.nio;

import java.nio.ByteBuffer;

/**
 * @author taobaibai
 * @create 2020-04-06 11:32
 */
public class TestBuffer01 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(1024); //JVM
        ByteBuffer.allocateDirect(1024);// 直接分配OS
        doPrint(buffer.position(),buffer.limit(),buffer.capacity());
        buffer.put("hello".getBytes());
        doPrint(buffer.position(),buffer.limit(),buffer.capacity());
        buffer.flip(); //切换读模式
        doPrint(buffer.position(),buffer.limit(),buffer.capacity());
        char c = (char)buffer.get();
        System.out.println("char="+c);
        doPrint(buffer.position(),buffer.limit(),buffer.capacity());
        buffer.compact(); //清除已读数据
        doPrint(buffer.position(),buffer.limit(),buffer.capacity());
        buffer.clear(); //清除全部
        doPrint(buffer.position(),buffer.limit(),buffer.capacity());
    }

    public static void doPrint(Integer position, Integer limit, Integer capacity) {
        System.out.println("[Position:"+position+", Limit:"+limit+", Capacity:"+capacity+"]");
    }

}
