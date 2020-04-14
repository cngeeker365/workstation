package com.jdk.highLevel.wangwenjun.concurrency.chapter1.taxCal;

/**
 * @author taobaibai
 * @create 2020-04-11 20:41
 */
public class TaxCalculatorStrategySimpleImpl implements TaxCalculatorStrategy {
    private final static double SALARY_RATE = 0.1;
    private final static double BONUS_RATE = 0.1;
    @Override
    public double calculate(double salary, double bonux) {
        return salary * SALARY_RATE + bonux * BONUS_RATE;
    }
}
