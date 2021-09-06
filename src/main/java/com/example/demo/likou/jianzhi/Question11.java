package com.example.demo.likou.jianzhi;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/8/6 17:06
 */
public class Question11 {

    public int minArray(int[] numbers) {
        if(numbers.length == 1){
            return numbers[0];
        }
        for(int i=0;i<numbers.length;i++){
            if(i!= 0 && numbers[i]<numbers[i-1]){
                return numbers[i];
            }
        }
        return numbers[0];
    }

}
