package com.example.demo.huawei;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String[] split = str.split(";");
            int[] flag = {0,0};
            for(int i=0;i<split.length;i++){
                if(!isMatch(split[i])){
                    continue;
                }
                switch (split[i].substring(0,1)){
                    case "A":
                        flag[0] = flag[0] - Integer.valueOf(split[i].substring(1));
                        break;
                    case "S":
                        flag[1] = flag[1] - Integer.valueOf(split[i].substring(1));
                        break;
                    case "D":
                        flag[0] = flag[0] + Integer.valueOf(split[i].substring(1));
                        break;
                    case "W":
                        flag[1] = flag[1] + Integer.valueOf(split[i].substring(1));
                        break;
                    default:
                        break;
                }
            }
            System.out.println(flag[0]+","+flag[1]);
        }

    }

    private static boolean isMatch(String s) {
        List<String> list = Arrays.asList("A","D","S","W");
        if(s.equalsIgnoreCase("x") || "".equals(s) || !list.contains(s.substring(0,1)) || s.length() >3 || !s.substring(1).matches("^[0-9]*$")){
            return false;
        }
        return true;
    }
}