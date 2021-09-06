package com.example.demo.likou.jianzhi;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/7/15 09:23
 */
public class Question4 {

    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        if (matrix.length == 1) {
            if(matrix[0].length == 0){
                return false;
            }
            for(int i = 0;i<matrix[0].length;i++){
                if(matrix[0][i] == target){
                    return true;
                }
            }
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }else if(matrix[i][j] < target){
                j++;
            }else {

            }
        }
        return false;
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Question4 question4 = new Question4();
        int[][] matrix = {
            {1,4,7,11,15},
            {2,5,8,12,19},
            {3,6,9,16,22},
            {10,13,14,17,24},
            {18,21,23,26,30},
        };
        int[][] matrix2 = {
            {1,2,3,4,5},
            {6,7,8,9,10},
            {11,12,13,14,15},
            {16,17,18,19,20},
            {21,22,23,24,25},
        };

        int[][] m2 = {{-1,3}};
        int t = 5;
        int target = 5;
        //System.out.println(question4.findNumberIn2DArray2(matrix,target));
       // System.out.println(question4.findNumberIn2DArray(matrix2,t));
    }

}
