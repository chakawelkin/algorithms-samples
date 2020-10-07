package com.chaka.algorithms.string;

/**
 * <a href="https://leetcode-cn.com/problems/distinct-subsequences/">不同的子序列</a>
 */
public class DistinctSubsequences {

    public int numDistinct(String t, String s) {
        if(s == null || t == null){
            return 0;
        }
        int row = s.length();
        int col = t.length();
        int[][] ans = new int[row + 1][col + 1];
        for (int i = 0; i <= col; i++) {
            ans[0][i] = 1;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (s.charAt(i) == t.charAt(j)){
                    ans[i + 1][j + 1] = ans[i][j] + ans[i+1][j];
                }else {
                    ans[i + 1][j + 1] = ans[i+1][j];
                }
            }
        }
        return ans[row][col];
    }

}