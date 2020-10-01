package com.chaka.algorithms.string;

/**
 * <a href="https://leetcode-cn.com/problems/edit-distance/">编辑距离</a>
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null){
            return 0;
        }
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        //初始化值
        for (int i = 1; i <= chars1.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= chars2.length; i++) {
            dp[0][i] = i;
        }

        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                if (chars1[i] == chars2[j]){
                    dp[i+1][j+1] = dp[i][j];
                }else {
                    dp[i+1][j+1] = Math.min(Math.min(dp[i][j],dp[i][j+1]),dp[i+1][j]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        EditDistance solve = new EditDistance();
        System.out.println(solve.minDistance("horse","ros"));
    }

}