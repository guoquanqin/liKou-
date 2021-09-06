package com.example.demo.likou;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/5/19 14:21
 */
public class Question17 {

    public static List<String> letterCombinations(String digits) {
        if(digits.equals("")){
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        Map<String,String> map = new HashMap<>(8);
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
        List<String> list = new ArrayList<>();
        getCombination(list,map,digits,0,new StringBuffer());
        return list;
    }

    private static void getCombination(List<String> list, Map<String, String> map, String digits, int dindex,
        StringBuffer str) {
        if (dindex >= digits.length()){
            list.add(str.toString());
            return;
        }
        String s = map.get(String.valueOf(digits.charAt(dindex)));
        for(int k =0;k<s.length();k++){
            str.append(s.charAt(k));
            getCombination(list, map, digits, dindex + 1, str);
            str.deleteCharAt(dindex);
        }

    }

    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }

}
