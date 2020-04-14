package com.jdk.highLevel.wangwenjun.concurrency.chapter1.taxCal;

/**
 * @author taobaibai
 * @create 2020-04-11 20:38
 */
public interface TaxCalculatorStrategy {
    public double calculate(double salary, double bonux);
}

