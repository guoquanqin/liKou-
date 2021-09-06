package com.example.demo.likou;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/5/26 10:41
 */
public class Question22 {
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(list,n,0,0,new StringBuilder());
        return list;
    }

    private static void generate(List<String> list, int n, int i, int j, StringBuilder str) {
        // 以"(" 开头如果i<3 ,选择 ) 或者选择 (
        if(str.length() == n*2){
            list.add(str.toString());
            return;
        }
        if(i<n){
            str.append("(");
            // 这里如果用 i++ 或 ++i 会有不一样的效果，一个是先赋值后加，一个是先加后赋值
            generate(list,n,i+1,j,str);
            // 每次加完要删掉之前的内容，不然只会有一条数据
            str.deleteCharAt(str.length()-1);
        }
        if(i > j){
            str.append(")");
            generate(list,n,i,j+1,str);
            str.deleteCharAt(str.length()-1);
        }

    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
