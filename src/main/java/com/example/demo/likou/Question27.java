package com.example.demo.likou;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/6/5 11:21
 */
public class Question27 {

    public static int removeElement(int[] nums, int val) {
        int n = 0;
        for(int i =0;i<nums.length;i++){
            if(val == nums[i]){
                n++;
            }else {
                int swap = nums[i];
                nums[i] = nums[i-n];
                nums[i-n] = swap;
            }
        }
        return nums.length - n;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums,2));
    }

}
