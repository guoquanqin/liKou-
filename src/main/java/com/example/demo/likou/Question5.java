package com.example.demo.likou;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/4/30 15:17
 */
public class Question5 {

    // 记录开始和结束索引
    int start = 0;
    int end = 0;
    public String longestPalindrome(String s) {
        if(s.length() == 0){
            return "";
        }
        if(s.length() == 1 || s.length() == 2){
            return String.valueOf(s.charAt(0));
        }
        // 初始化集合
        int[] temp = new int[128];
        for(int i =0;i<temp.length;i++){
            temp[i] = -1;
        }
        f(s,temp);
        StringBuffer str = new StringBuffer();
        for(int i =start;i<= end ;i++){
            str.append(s.charAt(i));
        }
        return str.toString();
    }

    private void f(String s,int[] temp) {
        /*for(int i =0;i<s.length();i++){
            // 证明已经重复了，判断是否需要递归
            if(temp[s.charAt(i)] == 1){
                if(end - start < i - start){
                    end = i;
                    f(s.substring(start+1),temp);
                    break;
                }
            }
            temp[s.charAt(i)] = 1;
        }*/
        int i = 0;
        while (i<s.length()){
            if(temp[s.charAt(i)] == 1){
                if(end - start < i - start){
                    end = i;
                    i++;
                    f(s.substring(start+1),temp);
                    break;
                }
            }
            temp[s.charAt(i++)] = 1;
        }
    }

    public static void main(String[] args) {
        Question5 quesytion5 = new Question5();
        String ababc = quesytion5.longestPalindrome("cbbd");
        System.out.println(ababc);
    }
}
