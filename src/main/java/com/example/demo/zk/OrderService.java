package com.example.demo.zk;

import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Service;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/6/16 18:29
 */
@Service("orderService")
public class OrderService implements Runnable{
    private OrderNumGenerator orderNumGenerator = new OrderNumGenerator();

    //发令枪，模拟50个并发
    private static CountDownLatch countDownLatch = new CountDownLatch(50);

    //    private Lock lock = new ZookeeperDistrbuteLock();

    private Lock lock = new ZookeeperDistrbuteLock();

    @Override
    public void run() {
        getNumber();
    }
    public void getNumber() {
        try {
            countDownLatch.await();
            lock.getLock();
            String number = orderNumGenerator.getNumber();
            System.out.println(Thread.currentThread().getName() + ",生成订单ID:" + number);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unLock();
        }
    }
    public static void main(String[] args){

        System.out.println("####生成唯一订单号###");

        for (int i = 0; i < 50; i++) {
            new Thread(new OrderService()).start();
            countDownLatch.countDown();
        }

    }
}
