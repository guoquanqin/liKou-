package com.example.demo.classloader;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/6/29 18:01
 */
public class SubClass extends SuperClass{
    static {
        System.out.println("SubClass init");
    }
}
