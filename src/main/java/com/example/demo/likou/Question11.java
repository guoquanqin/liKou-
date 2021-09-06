package com.example.demo.likou;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/5/7 18:17
 */
public class Question11{

    public static int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length-1;
        // 双指针处理
        while (i<j){
            int min = Math.min(height[i],height[j]);
            max = min*(j-i) > max ? min*(j-i) :max;
            if (min == height[i]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,8,6,2,5,4,8,3,7};
        int[] b = new int[]{1,1};
        int[] c = new int[]{4,3,2,1,4};
        int[] d = new int[]{1,2,1};
        System.out.println(maxArea(a));
        System.out.println(maxArea(b));
        System.out.println(maxArea(c));
        System.out.println(maxArea(d));
    }
}
