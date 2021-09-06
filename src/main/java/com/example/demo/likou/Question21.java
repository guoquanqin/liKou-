package com.example.demo.likou;

import java.util.Queue;
import java.util.Stack;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/5/19 18:24
 */
public class Question21 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 != null && l2 == null){
            return l1;
        }
        if(l1 == null && l2 != null){
            return l2;
        }
        ListNode listNode = new ListNode();
        ListNode nextNode = listNode;
        while (l1 != null && l2 != null){
            if(l1.val > l2.val){
                nextNode.next = l2;
                l2 = l2.next;
            }else {
                nextNode.next = l1;
                l1 = l1.next;
            }
            nextNode = nextNode.next;
        }
        if(l1 != null){
            nextNode.next = l1;
        }
        if(l2 != null){
            nextNode.next = l2;
        }
        return listNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        l1.val = 2;
        /*ListNode l2 = new ListNode();
        l2.val = 2;
        l2.next = l1;
        ListNode l3 = new ListNode();
        l3.val = 1;
        l3.next = l2;*/


        ListNode l4 = new ListNode();
        l4.val = 1;
        /*ListNode l5 = new ListNode();
        l5.val = 3;
        l5.next = l4;
        ListNode l6 = new ListNode();
        l6.val = 1;
        l6.next = l5;*/

        System.out.println(mergeTwoLists(l1, l4));
    }
}
