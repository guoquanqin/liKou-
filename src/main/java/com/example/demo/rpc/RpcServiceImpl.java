package com.example.demo.rpc;

import org.springframework.stereotype.Service;

/**
 * RpcServiceImpl
 *
 * @author gqq
 * @version 1.0, 2021/8/17 15:01
 */
@Service
public class RpcServiceImpl implements RpcService{

    @Override
    public String hello() {
        return "hello fucking man";
    }
}
