package com.jdk.highLevel.wangwenjun.concurrency.chapter1.taxCal;

/**
 * @author taobaibai
 * @create 2020-04-09 23:24
 */
public class TaxCalculator {
    private final double salary;
    private final double bonus;
    private TaxCalculatorStrategy strategy;

    public TaxCalculator(double salary, double bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }

    protected double calcTax(){
        return strategy.calculate(salary,bonus);
    }

    public double calcuate(){
        return this.calcTax();
    }

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }

    public TaxCalculatorStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(TaxCalculatorStrategy strategy) {
        this.strategy = strategy;
    }
}
