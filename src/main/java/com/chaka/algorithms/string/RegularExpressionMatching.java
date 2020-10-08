package com.chaka.algorithms.string;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode-cn.com/problems/regular-expression-matching/">正则表达式匹配</a>
 *  1、'.'匹配任意一个字符
 *  2、'*'匹配零个或多个前面的字符
 */
public class RegularExpressionMatching {

    private Map<String,Boolean> memo = new HashMap<>();

    public boolean isMatch(String s, String p) {
        if (s == null || p == null){
            return false;
        }
        while (p.length() > 0 && p.charAt(0) == '*'){
            p = p.substring(1);
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 2; j <= p.length(); j++) {
            //当前是'*'，且
            if (p.charAt(j - 1) == '*' && dp[0][j-2]){
                dp[0][j] = true;
            }
        }
        for (int i = 1;i <= s.length();i++){
            for (int j = 1; j <= p.length();j++){
                //相等
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }
                //
                if (p.charAt(j - 1) == '*'){
                    if (dp[i][j-2]){
                        dp[i][j] = dp[i][j-2];
                    }else {
                        if (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.'){
                            dp[i][j] = dp[i-1][j];
                        }
                    }

                }
            }
        }
        return dp[s.length()][p.length()];
    }

    //动态规划dp，未通过
    private boolean dp(String s,int i,String p,int j){
        int m = s.length(), n = p.length();
        if (j == n){
            return i == m;
        }
        //如果S遍历完了，那么
        if (i == m){
            if ((n - j) % 2 == 1) {
                return false;
            }
            for (; j + 1 < n; j += 2) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
            }
            return true;
        }
        //匹配
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
            //看一下j+1是不是为*
            if (j + 1 < n && p.charAt(j+1) == '*'){
                return dp(s,i+1,p,j+2) || dp(s,i+1,p,j);
            }else {
                return dp(s,i+1,p,j+1);
            }
        }else {
            //j+1位置只能匹配0
            if (j + 1 < n && p.charAt(j+1) == '*'){
                return dp(s,i,p,j+2);
            }else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        RegularExpressionMatching solve = new RegularExpressionMatching();
        solve.isMatch("ab",
                ".*c");
    }

}