package com.example.demo.rpc;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/8/17 16:20
 */
public class RpcTest {

    public static void main(String[] args) {
        RpcService service = new RpcServiceImpl();
        try {
            // 服务暴露
            RpcFramework.export(service,8013);

            // 服务引用
            com.example.demo.rpc.RpcService refer = RpcFramework.refer(RpcService.class, "127.0.0.1", 8013);
            System.out.println(refer.hello());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
