package com.chaka.algorithms.string;

/**
 * <a href="https://leetcode-cn.com/problems/valid-palindrome/">验证回文串</a>
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j){
            char c;
            //不是字母
            while (i < j && !Character.isLetterOrDigit(c = s.charAt(i))){
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(c = s.charAt(j))){
                j--;
            }
            if (i < j && Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome solve = new ValidPalindrome();
        System.out.println(solve.isPalindrome("A man, a plan, a canal: Panama"));
    }
}