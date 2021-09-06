package com.example.demo.likou;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/6/21 16:57
 */
public class Question36 {

    public boolean isValidSudoku(char[][] board) {
        int start = 0;
        int end = 0;
        // 比较行列
        for(int i =0;i<board.length;i++){
            // 行
            List<Character> rowList = new ArrayList<>();
            // 列
            List<Character> columnList = new ArrayList<>();
            for(int j =0;j<board[i].length;j++){
                // 行竖都为 '.' 才能退出
                if(board[j][i] != '.'){
                    if(rowList.contains(board[j][i])){
                        return Boolean.FALSE;
                    }else {
                        rowList.add(board[j][i]);
                    }
                }
                if(board[i][j] != '.'){
                    if(columnList.contains(board[i][j])){
                        return Boolean.FALSE;
                    }else {
                        columnList.add(board[i][j]);
                    }
                }
            }
            // 9宫格
            List<Character> nineList = new ArrayList<>();
            for(int k =start;k<start+3;k++){
                for(int s =end;s<end+3;s++){
                    if(board[k][s] == '.'){
                        continue;
                    }
                    if(nineList.contains(board[k][s])){
                        return Boolean.FALSE;
                    }
                    nineList.add(board[k][s]);
                }
            }
            if(end == 6){
                end = 0;
                start += 3;
            }else {end += 3;}
        }
        return Boolean.TRUE;
    }

    public static void main(String[] args) {
        Question36 question36 = new Question36();
        char[][] board = {{'1','3','.','.','7','.','.','.','.'}
,{'6','.','.','1','9','5','.','.','.'}
,{'.','9','8','.','.','.','.','6','.'}
,{'8','.','.','.','6','.','.','.','3'}
,{'4','.','.','8','.','3','.','.','1'}
,{'7','.','.','.','2','.','.','.','6'}
,{'.','6','.','.','.','.','2','8','.'}
,{'.','.','.','4','1','9','.','.','5'}
,{'.','.','.','.','8','.','.','7','9'}};

        char[][] board1 = {
            {'.','.','4','.','.','.','6','3','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'5','.','.','.','.','.','.','9','.'},
            {'.','.','.','5','6','.','.','.','.'},
            {'4','.','3','.','.','.','.','.','1'},
            {'.','.','.','7','.','.','.','.','.'},
            {'.','.','.','5','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'}};

        char[][] board2 = {
            {'7','.','.','.','4','.','.','.','.'},
            {'.','.','.','8','6','5','.','.','.'},
            {'.','1','.','2','.','.','.','.','.'},
            {'.','.','.','.','.','9','.','.','.'},
            {'.','.','.','.','5','.','5','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','2','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'}};
        System.out.println(question36.isValidSudoku(board));
    }

}
