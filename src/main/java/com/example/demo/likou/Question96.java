package com.example.demo.likou;

import com.example.demo.likou.Question95.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/5/6 17:25
 */
public class Question96 {

    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0] = 1;
        G[1] = 1;
        for(int i = 2;i<=n;i++){
            for(int j = 1;j<=i;j++){
                G[i] += G[j-1]*G[i-j];
            }
        }
        return G[n];
    }

    public static void main(String[] args) {
        Question96 q = new Question96();
        System.out.println(q.numTrees(3));
    }
}
