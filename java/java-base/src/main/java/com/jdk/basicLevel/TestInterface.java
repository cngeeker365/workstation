package com.jdk.basicLevel;

public class TestInterface {
    public static void main(String[] args) {
        System.out.println(Rollable.ball);
        Rollable.test();
        Rollable.ball.play();
        Rollable.ball.help();
    }
}

interface Playable{
    void play();
    default void help(){
        System.out.println("Playable --- help");
    }
}

interface Bounceable{
    void play();
    default void help(){
        System.out.println("Bounceable --- help");
    }
}

interface Rollable extends Playable, Bounceable{
   Ball ball = new Ball("PingPang");

   public static void test(){
       System.out.println("静态方法");
   }

   public default void test2(){
       System.out.println("默认方法");
   }

   @Override
   public default void help(){
       Playable.super.help();
       Bounceable.super.help();
   }
}

class Ball implements Rollable{
    private String name;

    public String getName() {
        return name;
    }
    public Ball(String name){
        this.name = name;
    }

    @Override
    public void play(){
//        ball = new Ball("Football"); //接口中定义的属性是public static final，不可修改
        System.out.println(ball.getName());
    }

    @Override
    public void test2() {
        System.out.println("覆盖默认方法");
    }

}