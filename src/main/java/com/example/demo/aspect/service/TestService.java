package com.example.demo.aspect.service;

import com.example.demo.aspect.annotation.ApiDemo;
import org.springframework.stereotype.Service;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2020/10/26 15:38
 */
@Service
public class TestService {

    @ApiDemo(name = "gqq")
    public String test(){
        return "success";
    }

}
