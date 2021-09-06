package com.example.demo.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int totalMoney = sc.nextInt();
            int count = sc.nextInt();
            int[] money = new int[count];
            int[] value = new int[count];
            int[] type = new int[count];
            for(int i = 0;i < count;i++){
                money[i] = sc.nextInt();
                value[i] = sc.nextInt();
                type[i] = sc.nextInt();
            }
            System.out.println(getMaxValue(value,money,type,count,totalMoney));

        }

    }

    /**
     *
     * @param value 物品的重要度
     * @param money 物品的价格
     * @param type  是否附件
     * @param count 物品个数
     * @param totalMoney  总价值
     * @return
     */
    private static int getMaxValue(int[] value, int[] money, int[] type, int count, int totalMoney) {
        int[][] dp = new int[count + 1][totalMoney + 1];
        for (int i = 1; i <= count; i++) {
            for (int j = 1; j <= totalMoney; j++) {
                // 主件
                if (type[i-1] == 0) {
                    // 用j这么多钱去买 i 件商品 可以获得最大价值
                    if (money[i - 1] <= j)
                    {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j- money[i - 1]]+ value[i - 1]);
                    }
                }
                else { //附件
                    if (money[i - 1] + money[type[i - 1]] <= j) //附件的话 加上主件一起算
                    {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j- money[i - 1]]+ value[i - 1]);
                    }
                }
            }
        }
        return dp[count][totalMoney];
    }
}