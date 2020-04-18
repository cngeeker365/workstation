package com.jdk.wangwenjun.chapter4.c04_jni;

/**
 * 【 Java 调用 C 】
 * 编译：          javac Hello.java
 * 头文件：        javah -jni Hello，生产 c 的头文件
 * 编写 Hello.c
 * 编译 Hello.c：  gcc -fPIC -D_REENTRANT -I"JAVA_HOME/include" -I"JAVA_HOME/include/linux" -c Hello.c ，生成目标文件 Hello.o
 * 生成库：        gcc -shared Hello.o -o libhello.so
 *                chmod 777 libhello.so
 * 执行：          java Hello
 *
 * @author taobaibai
 * @create 2020-04-17 22:57
 */
public class Hello {
    static {
        System.loadLibrary("hello");
    }
    private native void hi();

    public static void main(String[] args) {
        new Hello().hi();
    }
}
