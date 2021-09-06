package com.example.demo.likou;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/5/4 09:45
 */
public class Question6 {

    public static String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        char[] chars = s.toCharArray();
        String[][] result = new String[numRows][s.length()];
        Boolean z = false;
        // 记录行数
        int column = 0;
        // 记录列数
        int row = 0;

        for(int i =  0; i<chars.length;i++){
            if(row == numRows){
                column++;
                row = row-2;
                result[row][column] = String.valueOf(s.charAt(i));
                z = true;
                continue;
            }
            if(row < numRows && !z){
                result[row][column] = String.valueOf(s.charAt(i));
                row++;
                continue;
            }
            if(row <= 1){
                if(row == 0){
                    row++;
                    result[row][column] = String.valueOf(s.charAt(i));
                    row = 0;
                    column++;
                }else{
                    row--;
                    column++;
                    result[row++][column] = String.valueOf(s.charAt(i));
                }
                z = false;
                continue;
            }
            row--;
            column++;
            result[row][column] = String.valueOf(s.charAt(i));
        }

        StringBuffer str = new StringBuffer();
        for(int i = 0;i<result.length;i++){
            for(int j = 0;j<result[i].length;j++){
                if(result[i][j] != null){
                    str.append(result[i][j]);
                }
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String paypalishiring = convert("abcde", 2);
        System.out.println(paypalishiring);
    }
}
