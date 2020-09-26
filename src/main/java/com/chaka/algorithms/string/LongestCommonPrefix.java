package com.chaka.algorithms.string;

/**
 * <a href="https://leetcode-cn.com/problems/longest-common-prefix">最长公共前缀</a>
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            int j = 0;
            for (;j < chars.length && j < ans.length(); j++) {
                if (ans.charAt(j) != chars[j]){
                    break;
                }
            }
            ans = ans.substring(0,j);
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestCommonPrefix solve = new LongestCommonPrefix();
        System.out.println(solve.longestCommonPrefix(new String[]{"flower","","flight"}));
    }

}