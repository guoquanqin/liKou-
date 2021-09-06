package com.example.demo.likou.jianzhi;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/7/28 18:00
 */
public class Question10 {
    private Map<Integer,Integer> map = new HashMap<>();
    public int fib(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }
        int r = (fib(n - 1) + fib(n - 2)) % 1000000007;
        map.put(n,r);
        return r;
    }

    public int numWays(int n) {
        int a = 1, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }


    public static void main(String[] args) {
        Question10 question10 = new Question10();
        //System.out.println(question10.fib(7));
        System.out.println(question10.numWays(5));

    }
}
