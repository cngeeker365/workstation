package com.jdk.wangwenjun.chapter2.c07_immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author taobaibai
 * @create 2020-04-14 20:22
 */
public class ImmutableTest {
    private final int age;
    private final String name;
    private final List<String> list;

    public ImmutableTest(int age, String name) {
        this.age = age;
        this.name = name;
        list = new ArrayList<>();
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<String> getList() {
        return Collections.unmodifiableList(list);
    }
}
