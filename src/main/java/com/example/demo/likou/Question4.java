package com.example.demo.likou;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/4/30 10:46
 */
public class Question4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 先排序，后获取
        int i = 0,j = 0,q =0;
        int k = nums1.length;
        int s = nums2.length;
        int[] temp = new int[k+s];
        while(i<k && j<s){
            if(nums1[i] <= nums2[j]){
                temp[q++] = nums1[i++];
            }else {
                temp[q++] = nums2[j++];
            }
        }
        // 判断哪个数组有剩余数据
        if(i < k){
            while (i < k){
                temp[q++] = nums1[i++];
            }
        } else if (j < s){
            while (j < s){
                temp[q++] = nums2[j++];
            }
        }
        Integer tempSize = temp.length;
        if(tempSize == 1){
            return temp[0];
        }
        int m  = tempSize / 2;
        if(tempSize % 2 == 0 ){
            float f = (float) (temp[m] + temp[m - 1]) /2;
            return Double.parseDouble(String.valueOf(f));
        }else {
            return temp[m];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

}
