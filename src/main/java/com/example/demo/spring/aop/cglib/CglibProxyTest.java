package com.example.demo.spring.aop.cglib;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/6/22 15:53
 */
public class CglibProxyTest {

    public static void main(String[] args) {
        // 代理类class文件存入本地磁盘方便我们反编译查看源码
        //System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "I:\\temp");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Hello.class);
        enhancer.setCallback(new MyMethodInterceptor());
        Hello hello = (Hello)enhancer.create();
        hello.say();
    }

}
