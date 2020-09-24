package com.chaka.algorithms.string;

/**
 * <a href="https://leetcode-cn.com/problems/jewels-and-stones/">宝石与石头</a>
 */
public class JewelsAndStones {

    public int numJewelsInStones(String J, String S) {
        int[] tag = new int[S.length()];
        char[] chars = J.toCharArray();
        int n = 0;
        for (int i = 0; i < chars.length; i++) {
            int start = 0;
            while (start < S.length()){
                if (tag[start] != 1 && chars[i] == S.charAt(start)){
                    n++;
                    tag[start] = 1;
                }
                start++;
            }
        }
        return n;
    }

}