package com.chaka.algorithms.string;

/**
 * <a href="https://leetcode-cn.com/problems/wildcard-matching/">通配符匹配</a>
 */
public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null){
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-1];
            }
        }
        for (int row = 1; row <= s.length(); row++) {
            for (int col = 1; col <= p.length(); col++){
                if (s.charAt(row - 1) == p.charAt(col - 1) || p.charAt(col - 1) == '?'){
                    dp[row][col] = dp[row-1][col-1];
                }
                if (p.charAt(col-1) == '*'){
                    dp[row][col] = dp[row][col-1] || dp[row-1][col];
                }
            }
        }
        return dp[s.length()][p.length()];
    }


    public static void main(String[] args) {
        WildcardMatching solve = new WildcardMatching();
        System.out.println(solve.isMatch("aa","*"));
    }
}
