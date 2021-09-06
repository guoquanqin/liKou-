package com.example.demo.likou;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/5/4 17:25
 */
public class Question8 {
    public static int myAtoi(String s) {
        char[] array = s.toCharArray();
        StringBuffer str = new StringBuffer();
        Boolean number = false;
        int i = 0;
        while (i<array.length){
            // 0不算
            if (array[i] >= 48 && array[i] <= 57){
                number = true;
                str.append(array[i++]);
                continue;
            }else if(number){
                break;
            }
            if(!number){
                if(array[i] == '-' || array[i] == '+'){
                    str.append(array[i]);
                    number = true;
                    i++;
                    continue;
                }else if(array[i] == ' '){
                    i++;
                    continue;
                }else {
                    return 0;
                }
            }
            i++;
        }
        if(str.toString().equals("") || str.toString().equals("-") || str.toString().equals("+")){
            return 0;
        }
        double num = Double.parseDouble(str.toString());
        return (int) (num > 0 ? Math.min(num, Integer.MAX_VALUE) : Math.max(num, Integer.MIN_VALUE));
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("20000000000000000000"));
        /*System.out.println(myAtoi("+1"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("-91283472332"));*/
    }
}
