package com.jdk.wangwenjun.chapter2.c04_observer.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taobaibai
 * @create 2020-04-14 14:49
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState(){
        return this.state;
    }

    public void setState(int state){
        if(state == this.state){
            return;
        }
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    private void notifyAllObservers(){
        observers.stream().forEach(Observer::update);
    }
}
