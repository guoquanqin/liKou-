package com.example.demo.huawei;

import java.util.HashMap;
import java.util.Scanner;


public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            if(isMatch(str)){
                System.out.println("OK");
            }else {
                System.out.println("NG");
            }
        }

    }

    private static boolean isMatch(String s) {
        if(s.length() <= 8){
            return false;
        }
        HashMap<Integer,Boolean> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                map.put(1,true);
            }else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                map.put(2,true);
            }else if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                map.put(3,true);
            }else {
                map.put(4,true);
            }
        }
        if(map.size() <3){
            return false;
        }
        int i =2;
        // 判断中间位和最后位是否被匹配
        Boolean middleMatch = false;
        Boolean lastMatch = false;
        while(i<s.length()){
            char[] index = {s.charAt(i-2),s.charAt(i-1),s.charAt(i)};
            for(int j=i-1;j<s.length();j++){
                if(j == s.length() -2){
                    break;
                }
                if(index[0] == s.charAt(j) && index[1] == s.charAt(j+1) && index[2] == s.charAt(j+2)){
                    return false;
                }
                if(index[1] == s.charAt(j)){
                    middleMatch = true;
                }
                if(index[2] == s.charAt(j)){
                    lastMatch = true;
                }
            }
            if(middleMatch){
                i ++;
                middleMatch = false;
            }else if(lastMatch){
                i += 2;
                lastMatch = false;
            }else {
                i += 3;
            }
        }
        return true;
    }
}