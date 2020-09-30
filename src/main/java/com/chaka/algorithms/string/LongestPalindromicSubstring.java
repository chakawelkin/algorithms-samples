package com.chaka.algorithms.string;

/**
 * <a href="https://leetcode-cn.com/problems/longest-palindromic-substring/">最长回文子串</a>
 *  中心扩展法
 *      1、aba
 *      2、caac
 *      3、adcbcdf --> start = 0, end = 6 i = 3 , len = 5
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = validLength(s, i, i);
            int len2 = validLength(s, i, i + 1);
            int len = Math.max(len1,len2);
            if (len > end -start){
                start = i - (len - 1) / 2;
                end = i + (len / 2);
            }
        }
        return s.substring(start, end + 1);
    }

    private int validLength(String s,int i,int j){
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return j - i - 1;
    }

}