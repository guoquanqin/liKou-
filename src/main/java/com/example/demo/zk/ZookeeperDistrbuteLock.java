package com.example.demo.zk;

import java.util.concurrent.CountDownLatch;
import org.I0Itec.zkclient.IZkDataListener;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/6/16 18:27
 */
public class ZookeeperDistrbuteLock extends ZookeeperAbstractLock{
    private CountDownLatch countDownLatch = null;

    @Override
    //尝试获得锁
    public  boolean tryLock() {
        try {
            zkClient.createEphemeral(PATH);
            return true;
        } catch (Exception e) {
            //如果创建失败报出异常
            //			e.printStackTrace();
            return false;
        }

    }

    @Override
    public void waitLock() {
        IZkDataListener izkDataListener = new IZkDataListener() {

            @Override
            public void handleDataDeleted(String path) throws Exception {
                // 唤醒被等待的线程
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }
            @Override
            public void handleDataChange(String path, Object data) throws Exception {

            }
        };
        // 注册事件
        zkClient.subscribeDataChanges(PATH, izkDataListener);
        System.out.println("注册事件");
        //如果节点存
        if (zkClient.exists(PATH)) {
            countDownLatch = new CountDownLatch(1);
            try {
                //等待，一直等到接受到事件通知
                countDownLatch.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 删除监听
        zkClient.unsubscribeDataChanges(PATH, izkDataListener);
        System.out.println("删除监听");
    }

    @Override
    public void unLock() {
        //释放锁
        if (zkClient != null) {
            zkClient.delete(PATH);
            zkClient.close();
            System.out.println("释放锁资源...");
        }
    }
}
