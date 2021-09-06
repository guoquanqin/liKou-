package com.example.demo.likou;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/5/28 10:15
 */
public class Question23 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        List<ListNode> list = Arrays.stream(lists).collect(Collectors.toList());
        list.removeAll(Collections.singleton(null));
        if(list.size() == 0){
            return null;
        }
        ListNode listNode = new ListNode();
        ListNode next = listNode;
        int i = list.size();
        while (i > 1){
            int min = Integer.MAX_VALUE;
            for(ListNode nodes : lists){
                if(nodes != null){
                    min = Math.min(nodes.val,min);
                }
            }
            for(int j = 0;j<lists.length;j++){
                ListNode node = lists[j];
                if(node == null){
                    continue;
                }
                if(node.val == min){
                    if(node.next == null){
                        i--;
                    }
                    next.next = node;
                    lists[j] = node.next;
                    next = next.next;
                    break;
                }
            }
        }
        for(ListNode nodes : lists){
            if(nodes != null){
                next.next = nodes;
            }
        }
        return listNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        l1.val = 11;
        ListNode l2 = new ListNode();
        l2.val = 5;
        l2.next = l1;
        ListNode l3 = new ListNode();
        l3.val = -1;
        l3.next = l2;


        ListNode l4 = new ListNode();
        l4.val = 4;
        ListNode l5 = new ListNode();
        l5.val = 3;
        l5.next = l4;
        ListNode l6 = new ListNode();
        l6.val = 1;
        l6.next = l5;

        ListNode l7 = new ListNode();
        l7.val = 10;
        ListNode l8 = new ListNode();
        l8.val = 6;
        l8.next = l7;
        //ListNode[] lists = {l3,l6,l8};
       // ListNode[] lists = {};
        ListNode[] lists = {null,l3,null,l8};
        System.out.println(mergeKLists(lists));
    }
}
