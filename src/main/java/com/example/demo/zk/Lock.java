package com.example.demo.zk;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/6/16 18:27
 */
public interface Lock {
    /**
     * 获取到锁的资源
     */
    void getLock();

    /**
     * 释放锁
     */
    void unLock();
}
