package com.chaka.algorithms.advanced_search;

/**
 * <a href="https://leetcode-cn.com/problems/valid-sudoku/description/">有效的数独</a>
 */
public class VlidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int[][] box = new int[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char val =  board[i][j];
                if (val == '.'){
                    continue;
                }
                int curr = val - '0';
                //这一行出现过该数字，返回失败
                if (row[i][curr]++ > 0 || col[j][curr]++ > 0){
                    return false;
                }
                int boxIdx = i/3 + (j/3)*3;
                if (box[boxIdx][curr]++ > 0){
                    return false;
                }
            }
        }
        return true;
    }

}
