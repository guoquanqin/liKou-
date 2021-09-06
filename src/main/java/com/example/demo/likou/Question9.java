package com.example.demo.likou;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/5/5 10:08
 */
public class Question9 {
    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int a = String.valueOf(x).length() - 1;
        int middle = String.valueOf(x).length() / 2;
        while (middle > 0){
            int b = x / new Double(Math.pow(10, a)).intValue();
            int c = x % 10;
            if(b != c){
                return false;
            }
            x = (x - b*new Double(Math.pow(10, a)).intValue() -c)/10;
            middle --;
            a = a-2;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(1221));
        System.out.println(isPalindrome(132231));
        System.out.println(isPalindrome(1325432));
        System.out.println(isPalindrome(1));
        System.out.println(isPalindrome(-101));
        System.out.println(isPalindrome(10));
    }
}
