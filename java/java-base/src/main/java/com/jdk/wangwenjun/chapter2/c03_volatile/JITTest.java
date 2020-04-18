package com.jdk.wangwenjun.chapter2.c03_volatile;

/**
 * @author taobaibai
 * @create 2020-04-17 11:14
 */
public class JITTest {
    private static boolean init = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(){
            @Override
            public void run() {
                /**
                 * v1.6 => 可退出
                 * v1.8 => 不退出
                 *      【1】 while(!init){} 在{} 内没有修改或其他操作，会被认为是 while(true){}，因此改变 init 无法退出循环
                 *      【2】 加上 System.out.println("...") 即可
                 */
                while (!init){
//                    System.out.println("...");
                }
            }
        }.start();
        Thread.sleep(1000);
        new Thread(){
            @Override
            public void run() {
                init = true;
                System.out.println("Set init = true.");
            }
        }.start();
    }
}
