package com.example.demo.likou.jianzhi;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/7/31 17:55
 */
public class Question14 {


    public int cuttingRope(int n) {
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        int result = 1;
        mul(n,result,1);
        return result;
    }

    private void mul(int n, int result,int i) {

    }

}
