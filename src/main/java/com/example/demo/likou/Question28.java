package com.example.demo.likou;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/6/5 11:48
 */
public class Question28 {
    public static int strStr(String haystack, String needle) {
        if(needle.equals("")){
            return 0;
        }
        int i = 0;
        // 相等的位置
        int k = 0;
        while(i<haystack.length()){
            // 用来标记是否匹配了
            Boolean flag = true;
            if(haystack.length()-i < needle.length()){
                return -1;
            }
            for(int n = 0;n<needle.length();n++){
                // 匹配到了
                if (flag && needle.charAt(n) == haystack.charAt(i)){
                    if(needle.charAt(0) == haystack.charAt(i) && k ==0 && n != 0){
                        k = i;
                    }
                    i++;
                }else {
                    flag = false;
                    // 匹配不到判断k有没有值，有就直接赋值并退出，没有就继续往下找
                    if(k != 0 && i != haystack.length() - 1){
                        i = k;
                        k = 0;
                        break;
                    }else if (k == 0 && needle.charAt(0) == haystack.charAt(i)){
                        break;
                    }
                    i++;
                }
            }
            if(flag){
                return i-needle.length();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        /*System.out.println(strStr("hello","ll"));
        System.out.println(strStr("aaaaa","bba"));*/
        System.out.println(strStr("mississippi","issip"));
        System.out.println(strStr("mississippi","sippj"));
    }
}
