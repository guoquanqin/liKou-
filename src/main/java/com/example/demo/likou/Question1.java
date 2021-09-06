package com.example.demo.likou;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/4/29 14:54
 */
public class Question1 {

    public int[] twoSum(int[] nums, int target) {
        int[] result = {};
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    result = new int[]{i, j};
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Question1 easyQuestion = new Question1();
        int[] nums = {3,2,4};
        int[] ints = easyQuestion.twoSum(nums, 6);
        for(int i= 0;i<ints.length;i++){
            System.out.println(ints[i]);

        }
    }
}
