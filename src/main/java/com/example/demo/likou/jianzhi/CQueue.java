package com.example.demo.likou.jianzhi;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Question9
 *
 * @author gqq
 * @version 1.0, 2021/7/28 16:51
 */
public class CQueue {

    // 插入栈(双端队列)
    private Deque<Integer> addStack;
    // 删除栈
    private Deque<Integer> delStack;
    public CQueue() {
        addStack = new LinkedList<>();
        delStack = new LinkedList<>();
    }

    public void appendTail(int value) {
        addStack.push(value);
    }

    public int deleteHead() {
        if(delStack.isEmpty()){
            // 转移
            while (!addStack.isEmpty()){
                delStack.push(addStack.pop());
            }
        }
        if(!delStack.isEmpty()){
            return delStack.pop();
        }
        return -1;
    }


    /**
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */
    public static void main(String[] args) {
        CQueue obj = new CQueue();
        int param1 = obj.deleteHead();
        obj.appendTail(5);
        obj.appendTail(2);
        int param2 = obj.deleteHead();
        int param3 = obj.deleteHead();
        System.out.println(param1 + " "+param2+" "+param3);
    }
}
