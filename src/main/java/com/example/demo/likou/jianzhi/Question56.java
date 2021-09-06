package com.example.demo.likou.jianzhi;

import org.noggit.JSONUtil;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/7/13 21:55
 */
public class Question56 {

        public int[] singleNumbers(int[] nums) {
            int ret = 0;
            for (int n : nums) {
                ret ^= n;
            }
            int div = 1;
            while ((div & ret) == 0) {
                div <<= 1;
            }
            int a = 0, b = 0;
            for (int n : nums) {
                if ((div & n) != 0) {
                    a ^= n;
                } else {
                    b ^= n;
                }
            }
            return new int[]{a, b};
        }

    public static void main(String[] args) {
        Question56 question56 = new Question56();
        System.out.println(JSONUtil.toJSON(question56.singleNumbers(new int[]{4,3,4,0,5,5})));
    }

}
