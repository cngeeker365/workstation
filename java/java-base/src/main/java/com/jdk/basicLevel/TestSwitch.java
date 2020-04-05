package com.jdk.basicLevel;

public class TestSwitch {
    public static void main(String[] args) {
        System.out.println(2<<3);

        int i=9;
        switch (i) {
            default:
                System.out.println("default");
            case 0:
                System.out.println("zero");
                break;
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
        }
        int result=0;
        i=2;
        switch(i){
            case 1:
                result=result +i;
            case 2:
                result=result+i*2;
            case 3:
                result=result+i*3;
        }
        System.out.println(result);
    }
}
