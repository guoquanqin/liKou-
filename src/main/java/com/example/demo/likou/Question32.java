package com.example.demo.likou;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/5/24 17:31
 */
public class Question32 {

    public static  int longestValidParentheses(String s) {
        /*if(s == ""){
            return 0;
        }
        Deque<Integer> deque = new LinkedList<>();
        int max = 0;
        int length = 0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i) == '('){
                deque.push(i);
            }else {
                if(deque.size() == 0){
                    if(i==1 && s.charAt(i-1) == '('){
                        length += 2;
                    }else {
                        max = Math.max(max,length);
                        length = 0;
                        continue;
                    }
                }else if(s.charAt(deque.pop()) == '('){
                    length += 2;
                }
            }
        }
        max = Math.max(max,length);
        return max;*/

        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.size() == 0) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;

    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(()"));
        System.out.println(longestValidParentheses("()"));
        System.out.println(longestValidParentheses("())((())"));
    }
}
