package com.example.demo.likou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/6/9 10:46
 */
public class Question30 {

    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String str : words){
            map.put(str,map.get(str)==null ? 1:1+map.get(str));
        }
        int tmpLength = words.length*words[0].length();
        List<Integer> list =new ArrayList<>();
        for(int i=0;i<s.length()- tmpLength +1;i++){
            HashMap<String,Integer> tmpMap = new HashMap<>();
            String r = s.substring(i,tmpLength+i);
            for(int j = 0;j<tmpLength;j+=words[0].length()){
                String str = r.substring(j,words[0].length()+j);
                tmpMap.put(str,tmpMap.get(str)==null ? 1:1+tmpMap.get(str));
            }
            if(map.equals(tmpMap)){
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Question30 q = new Question30();
        String[] words = {"foo","bar"};
        q.findSubstring("barfoothefoobarman",words);
    }

}
