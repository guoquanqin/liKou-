package com.example.demo.likou.jianzhi;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/7/21 16:24
 */
public class Question12 {

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(dfs(board,chars,i,j,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 深度优先搜索
     * @param board 数组
     * @param words 关键词
     * @param i 行
     * @param j 列
     * @param k 关键词位置索引
     */
    private Boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        if(i < 0 || i>=board.length || j<0 || j>=board[i].length || board[i][j] != words[k]) {
            return false;
        }
        if( k == words.length -1){
            return true;
        }
        board[i][j] = '\0';
        Boolean res = dfs(board,words,i+1,j,k+1) || dfs(board,words,i-1,j,k+1)
            || dfs(board,words,i,j+1,k+1) || dfs(board,words,i,j-1,k+1);
        board[i][j] = words[k];
        return res;
    }

    public static void main(String[] args) {
        Question12 question12 = new Question12();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] board2 = {{'a','b'},{'c','d'}};
        char[][] board3 = {{'a','a'}};
        String word = "ABCCED";
        String word2 = "abdc";
        String word3 = "aaa";
        System.out.println(question12.exist(board3,word3));
    }

}
