package com.example.demo.dynamic;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/5/22 10:28
 */
public class Package0_1 {

    public static int knapsack3(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w+1];
        for (int i = 0; i < n; ++i) { // 初始化states
            for (int j = 0; j < w+1; ++j) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        if (weight[0] <= w) {
            states[0][weight[0]] = value[0];
        }
        for (int i = 1; i < n; ++i) { //动态规划，状态转移
            for (int j = 0; j <= w; ++j) { // 不选择第i个物品
                if (states[i-1][j] >= 0) {
                    states[i][j] = states[i-1][j];
                }
            }
            for (int j = 0; j <= w-weight[i]; ++j) { // 选择第i个物品
                if (states[i-1][j] >= 0) {
                    int v = states[i-1][j] + value[i];
                    if (v > states[i][j+weight[i]]) {
                        states[i][j+weight[i]] = v;
                    }
                }
            }
        }
        // 找出最大值
        int maxvalue = -1;
        for (int j = 0; j <= w; ++j) {
            if (states[n-1][j] > maxvalue) {
                maxvalue = states[n-1][j];
            }
        }
        return maxvalue;
    }

    public static void main(String[] args) {
        // 结果放到maxW中
         int maxW = Integer.MIN_VALUE;
        // 物品重量
         int[] weight = {2,2,4,6,3};
        // 物品的价值
         int[] value = {3,4,8,9,6};
        // 物品个数
         int n = 5;
        // 背包承受的最大重量
         int w = 9;
        knapsack3(weight,value,n,w);
    }
}
