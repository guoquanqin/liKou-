package com.example.demo.likou;

import java.util.Objects;
import org.springframework.util.StringUtils;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/5/5 17:17
 */
public class Question10 {
    public static boolean isMatch(String s, String p) {
        if(s == "" && p == ""){
            return true;
        }
        if((StringUtils.isEmpty(s) && !StringUtils.isEmpty(p)) || StringUtils.isEmpty(p) && !StringUtils.isEmpty(s)){
            return false;
        }
        char[] array = p.toCharArray();
        int j = p.length() - 1;
        int f = j;
        // 从后往前遍历
        for(int i = s.length() - 1;i>=0;i--){
            // 证明还没验完
            if(j < 0){
                return false;
            }
            // 分为*和不为*两种
            if(array[j] == '*'){
                // 看前面一位是否等于当前数
                if(array[j-1] == s.charAt(i)){
                    f = j-1;
                    continue;
                }
                if(array[f-1] == '.'){
                    array[f-1] = s.charAt(i);
                    f  = f-2;
                    j = f;
                    continue;
                }else if(array[j-2] == s.charAt(i)){
                    j = j-3;
                    f = j;
                    continue;
                }else {
                    return false;
                }
            }else if(array[j] == s.charAt(i) || array[j] == '.'){
                j--;
                f = j;
                continue;
            }else {
                return false;
            }
        }
        // 如果还没验完的情况下
        if(f-1 > 0){
            if(f % 2 != 0){
                return false;
            }
            for(f=f-1;f>=0;f = f-2){
                if(array[f] != '*'){
                    return false;
                }else if(array[f-1] == '.' || array[f-1] != '*'){
                   continue;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /*System.out.println(isMatch("aa","a"));
        System.out.println(isMatch("aa","a*"));
        System.out.println(isMatch("aa",".*"));
        System.out.println(isMatch("aab","c*a*b"));*/
        System.out.println(isMatch("mississippi","mis*is*.p*."));
    }
}
