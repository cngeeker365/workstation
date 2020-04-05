package com.jdk.basicLevel;

public class TestInterfaceVar {

}

interface A{
    int x =0;
}

class B{
    int x = 1;
}

class C extends B implements A{
    public void pX(){
//        System.out.println(x); //错误写法：改为super.x
        System.out.println(super.x);
        System.out.println(A.x);
    }

    public static void main(String[] args) {
        new C().pX();
    }
}