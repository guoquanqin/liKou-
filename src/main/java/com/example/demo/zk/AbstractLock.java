package com.example.demo.zk;


/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/6/16 18:07
 */
public abstract  class AbstractLock  implements Lock {
    @Override
    public void getLock() {

        //任务通过竞争获取锁才能对该资源进行操作(①竞争锁)；
        // 当有一个任务在对资源进行更新时（②占有锁），
        // 其他任务都不可以对这个资源进行操作（③任务阻塞），
        // 直到该任务完成更新(④释放锁)
        //尝试获得锁资源

        //①竞争锁
        if (tryLock()) {
            System.out.println("##获取lock锁的资源####");
        } else {

            //③任务阻塞
            waitLock();

            // 重新获取锁资源
            getLock();
        }
    }

    // ②占有锁
    public abstract boolean tryLock();

    // 等待
    public abstract void waitLock();

}
