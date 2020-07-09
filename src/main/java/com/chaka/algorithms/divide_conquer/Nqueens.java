package com.chaka.algorithms.divide_conquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/n-queens/">N皇后</a>
 */
public class Nqueens {

    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        backtrack(board,0);
        return result;
    }

    public void backtrack(char[][] board,int row){
        if (row == board.length){
            List<String> list = new ArrayList<>();
            for (char[] chars : board) {
                list.add(new String(chars));
            }
            result.add(list);
            return;
        }
        char[] rowEle = board[row];
        for (int col = 0; col < rowEle.length; col++) {
            if (!isValid(board,row,col)){
                continue;
            }
            rowEle[col] = 'Q';
            //进入下一个决策树
            backtrack(board,row + 1);
            rowEle[col] = '.';
        }

    }

    /**
     * 判断当前是否合法
     * @param board
     * @param row
     * @param col
     * @return
     */
    private boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        //检查当前列是否有皇后冲突
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q'){
                return false;
            }
        }
        //检查左上方是否有皇后冲突
        for (int i = row - 1, j=col - 1; i >= 0 && j >= 0 ; i-- , j--) {
            if (board[i][j] == 'Q'){
                return false;
            }
        }
        //检查右上方是否有皇后冲突
        for (int i = row - 1, j=col + 1; i >= 0 && j < n ; i-- , j++) {
            if (board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Nqueens nqueens = new Nqueens();
        nqueens.solveNQueens(4);
    }

}
