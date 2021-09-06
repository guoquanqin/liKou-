package com.example.demo.likou.jianzhi;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/7/10 13:59
 */
public class Question3 {
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i<nums.length){
            if(i != nums[i]){
                if(nums[nums[i]] == nums[i]){
                    return nums[i];
                }
                int swap = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = swap;
            }
            i++;
        }
        return nums[0];
    }

    public static void main(String[] args) {
        Question3 question3 = new Question3();
        int repeatNumber = question3.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3});
        System.out.println("question3 = " + repeatNumber);
    }
}
