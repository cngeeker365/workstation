package com.jdk.wangwenjun.chapter3.c04_noParent;

import com.jdk.wangwenjun.chapter3.c02_myclassloader.MyClassLoader;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author taobaibai
 * @create 2020-04-16 22:33
 */
public class ThreadContextClassLoader {
    public static void main(String[] args) throws Exception {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);

        Thread.currentThread().setContextClassLoader(new MyClassLoader());
        System.out.println(Thread.currentThread().getContextClassLoader());

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("");
    }
}
