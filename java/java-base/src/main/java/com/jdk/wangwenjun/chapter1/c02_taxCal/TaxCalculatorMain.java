package com.jdk.highLevel.wangwenjun.concurrency.chapter1.taxCal;

/**
 * @author taobaibai
 * @create 2020-04-11 20:27
 */
public class TaxCalculatorMain {
    public static void main(String[] args) {
/*        TaxCalculator calculator = new TaxCalculator(10000d, 2000d){
            @Override
            protected double calcTax() {
                return getSalary()*0.1 + getBonus()*0.15;
            }
        };
        double tax = calculator.calcTax();
        System.out.println(tax);*/

        TaxCalculator calculator = new TaxCalculator(10000d, 2000d);
        TaxCalculatorStrategy strategy = new TaxCalculatorStrategySimpleImpl();
        calculator.setStrategy(strategy);
        System.out.println(calculator.calcuate());
    }
}
