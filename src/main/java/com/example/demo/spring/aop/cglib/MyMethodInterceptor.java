package com.example.demo.spring.aop.cglib;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/6/22 15:54
 */
public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("前置");
        Object invoke = method.invoke(o, objects);
        System.out.println("后置");
        return invoke;
    }
}
