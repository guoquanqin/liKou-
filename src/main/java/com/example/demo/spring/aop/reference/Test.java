package com.example.demo.spring.aop.reference;

import java.lang.ref.SoftReference;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/6/24 17:26
 */
public class Test {

    public static void main(String[] args){
        System.out.println("开始");
        A a = new A();
        SoftReference<A> sr = new SoftReference<A>(a);
        a = null;
        if(sr!=null){
            a = sr.get();
        }
        else{
            a = new A();
            sr = new SoftReference<A>(a);
        }
        System.out.println("结束");
    }

}

class A{
    int[] a ;
    public A(){
        a = new int[100000000];
    }
}
