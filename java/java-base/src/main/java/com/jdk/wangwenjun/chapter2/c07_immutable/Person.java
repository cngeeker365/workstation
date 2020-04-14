package com.jdk.wangwenjun.chapter2.c07_immutable;

/**
 * @author taobaibai
 * @create 2020-04-14 20:05
 */
public final class Person {
    private final String name;
    private final String addr;

    public Person(final String name, final String addr) {
        this.name = name;
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public String getAddr() {
        return addr;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
