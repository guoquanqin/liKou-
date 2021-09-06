package com.example.demo.likou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/5/19 16:56
 */
public class Question18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length < 4){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        Set<List<Integer>> list = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                for(int k = j+1;k<nums.length;k++){
                    for(int q = nums.length-1;q>k;q--){
                        int fourNum = target - (nums[i] + nums[j] + nums[k]);
                        if(fourNum == nums[nums.length-1]){
                            list.add(Arrays.asList(nums[i],nums[j],nums[k],nums[nums.length-1]));
                            continue;
                        }
                        if(fourNum == nums[q]){
                            list.add(Arrays.asList(nums[i],nums[j],nums[k],nums[q]));
                            break;
                        }
                    }
                }
            }
        }
        return new ArrayList<>(list);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,-1,0,-2,2};
        int[] nums1 = new int[]{2,2,2,2,2};
        int[] nums2 = new int[]{-1,0,1,2,-1,-4};
        System.out.println(fourSum(nums2,-1));
        System.out.println(fourSum(nums1,8));
        System.out.println(fourSum(nums,0));
    }
}
