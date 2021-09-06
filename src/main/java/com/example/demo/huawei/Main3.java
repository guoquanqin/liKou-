package com.example.demo.huawei;

import java.util.HashMap;
import java.util.Scanner;


public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            HashMap<Character,String> map = new HashMap();
            for(char i=97;i<=122;i++){
                if("abc".contains(Character.toString(i))){
                    map.put(i,"2");
                }else if("def".contains(Character.toString(i))){
                    map.put(i,"3");
                }else if("ghi".contains(Character.toString(i))){
                    map.put(i,"4");
                }else if("jkl".contains(Character.toString(i))){
                    map.put(i,"5");
                }else if("mno".contains(Character.toString(i))){
                    map.put(i,"6");
                }else if("pqrs".contains(Character.toString(i))){
                    map.put(i,"7");
                }else if("tuv".contains(Character.toString(i))){
                    map.put(i,"8");
                }else {
                    map.put(i,"9");
                }
            }
            for(int i=0;i<str.length();i++){
                if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                    sb.append(str.charAt(i));
                }else if(str.charAt(i) >= 'A' && str.charAt(i) < 'Z'){
                    sb.append((char) (str.charAt(i)+33));
                }else if(str.charAt(i) == 'Z'){
                    sb.append('a');
                    continue;
                }else {
                    sb.append(map.get(str.charAt(i)));
                }
            }
            System.out.println(sb);
        }

    }

}