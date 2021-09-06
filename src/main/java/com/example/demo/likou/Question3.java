package com.example.demo.likou;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/4/29 17:28
 */
public class Question3 {

    /*Integer max = 0;
    Integer count = 0;
    public Integer lengthOfLongestSubstring(String s) {
        if(s == ""){
            return 0;
        }
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(i == s.length()){
                return max;
            }
            if(map.get(s.substring(i,i+1)) != null){
                count = 0;
                String substring = s.substring(map.get(s.substring(i, i + 1)));
                lengthOfLongestSubstring(substring);
                break;
            }else {
                count++;
                if(count > max){
                    max = count;
                }
                map.put(s.substring(i,i+1),i+1);
            }
        }
        return max;
    }*/

    public int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }

    public static void main(String[] args) {
        Question3 question3 = new Question3();
        Integer pwwkew = question3.lengthOfLongestSubstring("pwwkew");
        System.out.println(pwwkew);
    }
}
