package com.jdk.wangwenjun.chapter4.c01_atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author taobaibai
 * @create 2020-04-17 16:58
 */
public class AtomicReferenceTest {
    public static void main(String[] args) {
        AtomicReference<Simple> atomicReference = new AtomicReference<>(new Simple("Alex", 18));
        System.out.println(atomicReference.get());

        //Compare: 比较的是内存地址，不是通过 equals
        boolean result = atomicReference.compareAndSet(new Simple("Alex", 18), new Simple("Alice", 12));

        System.out.println(result);
        System.out.println(atomicReference.get());
    }

    static class ObjectWrap<T>{
        private T t;

        public ObjectWrap(T t) {
            this.t = t;
        }

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }
    }

    static class Simple{
        private String name;
        private int age;

        public Simple(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
