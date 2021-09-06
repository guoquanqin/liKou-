package com.example.demo.likou;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/5/20 17:28
 */
public class Question20 {

    public static boolean isValid(String s) {
        // 双栈处理
        Map<String,String> map = new HashMap<>();
        map.put("}","{");
        map.put("]","[");
        map.put(")","(");
        Stack<String> stack = new Stack<>();
        Stack<String> target = new Stack<>();
        for(int i = 0;i<s.length();i++){
            stack.push(String.valueOf(s.charAt(i)));
        }
        while (!stack.empty()){
            if(target.empty() || map.get(target.peek()) == null || !map.get(target.peek()).equals(stack.peek())){
                target.push(stack.pop());
                continue;
            }
            if(map.get(target.peek()).equals(stack.peek())){
                stack.pop();
                target.pop();
            }
        }
        if(!target.empty()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }
}
