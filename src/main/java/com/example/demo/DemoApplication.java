package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication

public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        Object orderService = ctx.getBean("orderService");
        System.out.println(orderService);
    }

}
