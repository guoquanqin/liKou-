package com.example.demo.likou;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/5/11 14:47
 */
public class Question13 {

    public static int romanToInt(String s) {
        int r = 0;
        int[] sum = new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] str = new String[]{"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int i = str.length - 1;
        int k = 0;
        while (i>=0 && k < s.length()){
            if(String.valueOf(s.charAt(k)).equals(str[i])){
                k++;
                r += sum[i];
                continue;
            }
            if(k+1 < s.length() && (String.valueOf(s.charAt(k))+String.valueOf(s.charAt(k+1))).equals(str[i])){
                k = k+2;
                r += sum[i];
                continue;
            }
            i--;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println( romanToInt("DCXXI"));
    }

}
