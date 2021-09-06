package com.example.demo.spring.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/6/22 14:30
 */
public class WorkHandler implements InvocationHandler {

    private Object proxy ;

    public WorkHandler(Object p) {
        this.proxy = p;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在真实的对象执行之前我们可以添加自己的操作
        System.out.println("before invoke。。。");
        Object invoke = method.invoke(this.proxy, args);
        System.out.println(args);
        System.out.println(invoke);
        //在真实的对象执行之后我们可以添加自己的操作
        System.out.println("after invoke。。。");
        return invoke;
    }
}
