package com.example.demo.likou;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/5/7 17:38
 */
public class Question1486 {

    public static int xorOperation(int n, int start) {
        int a = 0;
        for (int i=0;i<n;i++){
            if(i == 0){
                a = start + 2*i;
                continue;
            }
            a ^=  start + 2*i;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(xorOperation(4,3));
        System.out.println(xorOperation(1,7));
        System.out.println(xorOperation(10,5));
    }

}
