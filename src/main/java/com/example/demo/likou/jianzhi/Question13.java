package com.example.demo.likou.jianzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/7/31 16:15
 */
public class Question13 {

    private int count = 0;
    public int movingCount(int m, int n, int k) {
        boolean[][] index = new boolean[m][n];
        turn(0,0,k,m,n,index);
        return count;
    }

    private void turn(int i, int j, int k, int m, int n, boolean index[][]) {
        if(m <= i || n <= j || i/10+i%10+j/10+j%10>k || index[i][j]){
            return;
        }
        index[i][j] = Boolean.TRUE;
        ++count;
        // 走右或走下
        if(i+1 < m){
            turn(i+1,j,k,m,n, index);
        }
        if(j+1 < n){
            turn(i,j+1,k,m,n, index);
        }
    }

    public static void main(String[] args) {
        Question13 question13 = new Question13();
        System.out.println(question13.movingCount(38,15,9));
        //System.out.println(question13.movingCount(2,3,3));
    }

}
