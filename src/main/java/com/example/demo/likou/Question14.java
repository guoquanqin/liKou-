package com.example.demo.likou;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/5/12 16:07
 */
public class Question14 {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        int min_length = strs[0].length();
        for(int i =0;i<strs.length;i++){
            min_length = strs[i].length() < min_length ? strs[i].length() : min_length;
        }
        int end = 0;
        for(int k = 0;k<min_length;k++){
            for(int i =1;i<strs.length;i++){
                if(strs[i].charAt(k) != strs[i-1].charAt(k)){
                    return strs[0].substring(0,end);
                }
                // 到了最后一步了
                if(i == strs.length-1){
                    end = k+1;
                }
            }
        }
        return strs[0].substring(0,end);
    }

    public static void main(String[] args) {
        String[] str =new String[]{"flower","flow","flight"};
        String[] str1 =new String[]{"cir","car"};
        //System.out.println(longestCommonPrefix(str));
        System.out.println(longestCommonPrefix(str1));
    }
}
