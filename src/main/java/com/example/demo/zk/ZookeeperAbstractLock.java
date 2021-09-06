package com.example.demo.zk;

import org.I0Itec.zkclient.ZkClient;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/6/16 18:08
 */
public abstract class ZookeeperAbstractLock extends AbstractLock{
    // zk连接地址
    private static final String CONNECTSTRING = "127.0.0.1:2181";
    // 创建zk连接
    protected ZkClient zkClient = new ZkClient(CONNECTSTRING);
    protected static final String PATH = "/lock";

}
