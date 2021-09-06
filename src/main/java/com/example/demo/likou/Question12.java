package com.example.demo.likou;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/5/11 14:47
 */
public class Question12 {
    public static String intToRoman(int num) {
        StringBuffer str = new StringBuffer();
        int[] sum = new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] s = new String[]{"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int i = sum.length - 1;
        while (i>=0){
            if(num>=sum[i]){
                str.append(s[i]);
                num = num - sum[i];
            }else {
                i--;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println( intToRoman(1994));
    }
}
