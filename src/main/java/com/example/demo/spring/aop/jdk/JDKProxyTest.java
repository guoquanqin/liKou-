package com.example.demo.spring.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/6/22 14:23
 */
public class JDKProxyTest {

    public static void main(String[] args) throws Exception {
        /*byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
            "$Proxy", new Class[]{People.class});
        FileOutputStream outputStream = new FileOutputStream("I:\\temp\\proxy.class");
        outputStream.write(proxyClassFile);
        outputStream.flush();
        outputStream.close();*/
        People p = new Teacher();
        InvocationHandler invocationHandler = new WorkHandler(p);
        People o = (People)Proxy
            .newProxyInstance(invocationHandler.getClass().getClassLoader(), p.getClass().getInterfaces(), invocationHandler);
        o.work();
    }

}
