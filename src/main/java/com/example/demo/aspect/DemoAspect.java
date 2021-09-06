package com.example.demo.aspect;

import com.example.demo.aspect.annotation.ApiDemo;
import java.lang.reflect.Method;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2020/10/26 15:25
 */
@Aspect
@Component
public class DemoAspect {

    @Pointcut("@annotation(com.example.demo.aspect.annotation.ApiDemo)")
    public void point() {
    }

    @Around(value ="point() && @annotation(annotation)")
    public Object useIdempotent(ProceedingJoinPoint pjp, ApiDemo annotation) throws Throwable {
        Object target = pjp.getTarget();
        System.out.println(target.getClass().getName());

        String name = pjp.getSignature().getName();
        System.out.println(name);

        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method != null)
        {
            ApiDemo apiLog=  method.getAnnotation(ApiDemo.class);
            System.out.println("切入方法注解的name:"+apiLog.name());
        }

        //4. 获取方法的参数
        Object[] args = pjp.getArgs();
        for(Object o :args){
            System.out.println("切入方法的参数："+o);
        }
        return null;
    }

}
