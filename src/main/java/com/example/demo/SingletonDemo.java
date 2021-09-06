package com.example.demo;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/5/30 15:04
 */
public class SingletonDemo {

    private static SingletonDemo instance;
    private SingletonDemo(){};
    private static final SingletonDemo getInstance(){
        if(null == instance){
            synchronized (SingletonDemo.class){
                if(null == instance){
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

}
