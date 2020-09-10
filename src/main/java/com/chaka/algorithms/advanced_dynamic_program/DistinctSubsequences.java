package com.chaka.algorithms.advanced_dynamic_program;

/**
 * <a href="https://leetcode-cn.com/problems/distinct-subsequences/">不同的子序列</a>
 */
public class DistinctSubsequences {

    public int numDistinct(String s, String t) {
        int[][] mem = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i <= t.length(); i++) {
            mem[0][i] = 1;
        }
        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (t.charAt(i) == s.charAt(j)){
                    mem[i+1][j+1] = mem[i][j] + mem[i + 1][j];
                }else {
                    mem[i+1][j+1] = mem[i+1][j];
                }
            }
        }
        return mem[t.length()][s.length()];
    }

}

/*
超时
public class DistinctSubsequences {

    private int count;

    public int numDistinct(String s, String t) {
        if (s.length() == t.length() && !s.equals(t)){
            return 0;
        }
        dfs(t,s);
        return count;
    }

    private void dfs(String small, String large) {
        if ("".equals(small)){
            count++;
            return;
        }
        //如果剩下的small长度还长于large可以直接parse
        if (small.length() > large.length()){
            return;
        }
        char c = small.charAt(0);
        for (int i = 0; i < large.length(); i++) {
            //找到了
            if (large.charAt(i) == c){
                dfs(small.substring(1),large.substring(i + 1));
            }
        }
    }

}*/
