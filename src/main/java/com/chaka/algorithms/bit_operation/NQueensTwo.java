package com.chaka.algorithms.bit_operation;

/**
 * <a href="https://leetcode-cn.com/problems/n-queens-ii/description/">N皇后 II</a>
 * 1、经典办法  位运算
 */
public class NQueensTwo {

    private int res;

    public int totalNQueens(int n) {
        dfs(n,0,0,0,0);
        return res;
    }

    private void dfs(int n,int row,int col,int ld,int rd){
        if (row >= n){
            res++;
            return;
        }
        //将所有能放置Q的位置置为1，进行后续遍历
        int bits = ~(col | ld | rd) & ((1 << n) - 1);
        while (bits > 0){
            int pick = bits & -bits;//拿到最后一个1
            dfs(n,row + 1,col | pick,(ld | pick) << 1,(rd | pick) >> 1);
            bits = bits & (bits - 1);//移除最后一个1
        }
    }

    public static void main(String[] args) {
        NQueensTwo solve = new NQueensTwo();
        System.out.println(solve.totalNQueens(4));
    }

}
