package com.jdk.wangwenjun.chapter2.c07_immutable;

import java.util.stream.IntStream;

/**
 * @author taobaibai
 * @create 2020-04-14 20:09
 */
public class ImmutableClient {
    public static void main(String[] args) {
        //Immutable Shared Data
        Person person = new Person("Alex", "GanSu");
        IntStream.range(0,5).forEach( i-> new UsePersonThread(person).start() );
    }
}
