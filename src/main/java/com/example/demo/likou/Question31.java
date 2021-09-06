package com.example.demo.likou;

import java.util.Arrays;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/6/10 14:10
 */
public class Question31 {
    public void nextPermutation(int[] nums) {
        if(nums.length == 1){
            return;
        }
        if(nums.length == 2 && nums[0] != nums[1]){
            exchange(nums,0,1);
            return;
        }
        for (int i = nums.length - 1; i > 0; i--) {
            // 从后往前遍历，如果i>i-1 ,调换顺序，后面用升序排列
            if (nums[i] > nums[i - 1]) {
                // 获取右数组比i大的最小值下标
                Integer rightMin = getRightMin(nums, nums[i - 1], i - 1);
                exchange(nums,rightMin,i-1);
                sort(nums,i);
                return;
            }
        }
        Arrays.sort(nums);
    }

    private Integer getRightMin(int[] nums, int num,int i) {
        int min = Integer.MAX_VALUE;
        for(;i<nums.length;i++){
            if(nums[i] <= num){
                continue;
            }
            min = Math.min(min,nums[i]);
        }
        for(;i<nums.length;i++){
            if(nums[i] == min){
                return i;
            }
        }
        return 0;
    }

    public void exchange(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sort(int[] nums,int i){
        for (int j = i; j < nums.length ; j++) {
            for (int k = j + 1; k < nums.length ; k++) {
                if (nums[j] > nums[k]) {
                    int t = nums[j];
                    nums[j] = nums[k];
                    nums[k] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        Question31 question31 = new Question31();
        int[] nums = {1,1,5};
        int[] nums1 = {1,3,2};
        int[] nums2 = {1,2};
        int[] nums3 = {5,4,7,5,3,2};
        question31.nextPermutation(nums3);
        System.out.println(nums1);
    }
}
