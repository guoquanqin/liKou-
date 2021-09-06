package com.example.demo.likou;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/6/7 15:17
 */
public class Question34 {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        if(nums.length == 0){
            return result;
        }
        getTarget(0,nums.length-1,nums,target,result);
        if(result[0] != -1 && result[1] ==-1){
            result[1] = result[0];
        }
        return result;
    }

    public void getTarget(int start, int end, int[] nums, int target, int[] result){
        if(start == end || start+1 == end){
            setResult(start, nums, target, result);
            setResult(end, nums, target, result);
            return;
        }
        int mid = (start+end) >> 1;
        getTarget(start,mid,nums,target,result);
        getTarget(mid+1,end,nums,target,result);
    }

    public void setResult(int s, int[] nums, int target, int[] result){
        if(nums[s] == target){
            if(result[0] ==-1){
                result[0] = s;
            }else if(result[1] == -1){
                result[1] = s;
            }else if(result[1] != -1 && result[1] < s){
                result[1] = s;
            }
        }
    }


    public static void main(String[] args) {
        Question34 question34 = new Question34();
        //int[] nums = {5,7,7,8,8,10};
        int[] nums = {3,3,3};
        int target = 3;
        int[] ints = question34.searchRange(nums, target);
        System.out.println(ints);
    }
}
