package com.example.demo.likou;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/4/29 15:32
 */
public class Question2 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        return root.next;
    }


    public static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /*public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // get count
        Integer count1 = getCount(l1);
        Integer count2 = getCount(l2);
        Integer count3 = count1 + count2;
        return generateListNode(count3);
    }*/

    private ListNode generateListNode(Integer count3) {
        ListNode listNode = null;
        int length = count3.toString().length();
        if(length == 1){
            listNode.val = count3;
            return listNode;
        }
        // count3 = 807 a = [8,0,7]
        int[] a = new int[length];
        for(int i = 0;i < length ;i++){
            a[i] = Integer.valueOf(count3.toString().substring(i,i+1));
        }
        for(int i = 0; i < length;i++){
            if(listNode != null){
                ListNode node = new ListNode(a[i],listNode);
                listNode = node;
            }else {
                listNode = new ListNode(a[i]);
            }
        }
        return listNode;
    }

    public Integer getCount(ListNode l){
        ListNode countList = l;
        Integer count = 1;
        while (countList.next != null){
            ++count;
            countList = countList.next;
        }
        if(count == 1){
            return l.val;
        }
        Integer sum = 0;
        for(int i = 0; i < count;i++){
            if (i == 0) {
                sum = l.val;
                l = l.next;
                continue;
            }
            double pow = Math.pow(10, i);
            sum += l.val*new Double(pow).intValue();
            if(l.next == null){
                break;
            }
            l = l.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        Question2 question2 = new Question2();
        ListNode l1 = new ListNode();
        l1.val = 3;
        ListNode l2 = new ListNode();
        l2.val = 4;
        l2.next = l1;
        ListNode l3 = new ListNode();
        l3.val = 2;
        l3.next = l2;

        ListNode l4 = new ListNode();
        l4.val = 4;
        ListNode l5 = new ListNode();
        l5.val = 6;
        l5.next = l4;
        ListNode l6 = new ListNode();
        l6.val = 5;
        l6.next = l5;

        ListNode listNode = question2.addTwoNumbers(l3, l6);
        System.out.println(listNode);
    }

}
