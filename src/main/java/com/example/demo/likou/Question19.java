package com.example.demo.likou;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/5/19 18:24
 */
public class Question19 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = dummy;
        while (cur!=null){
            stack.push(cur);
            cur = cur.next;
        }
        for(int i = 0;i<n;i++){
            stack.pop();
        }
        ListNode peek = stack.peek();
        peek.next = peek.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        l1.val = 5;
        ListNode l2 = new ListNode();
        l2.val = 4;
        l2.next = l1;
        ListNode l3 = new ListNode();
        l3.val = 3;
        l3.next = l2;
        ListNode l4 = new ListNode();
        l4.val = 2;
        l4.next = l3;
        ListNode l5 = new ListNode();
        l5.val = 1;
        l5.next = l4;

        System.out.println(removeNthFromEnd(l5, 2));
    }
}
