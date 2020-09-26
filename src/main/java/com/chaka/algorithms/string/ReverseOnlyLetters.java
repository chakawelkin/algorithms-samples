package com.chaka.algorithms.string;

/**
 * <a href="https://leetcode-cn.com/problems/reverse-only-letters/">仅仅反转字母</a>
 */
public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String S) {
        if (S == null || S.length() < 2){
            return S;
        }
        StringBuilder ans = new StringBuilder(S);
        int j = 0;
        for (int i = S.length() - 1; i >= 0 ; i--) {
            char c = S.charAt(i);
            if (isLetter(c)){
                //替换
                for (;j < ans.length();){
                    if (isLetter(ans.charAt(j++))){
                        ans.setCharAt(j -1,c);
                        break;
                    }
                }
            }
        }
        return ans.toString();
    }

    private boolean isLetter(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public static void main(String[] args) {
        ReverseOnlyLetters solve = new ReverseOnlyLetters();
        System.out.println(solve.reverseOnlyLetters("ab-cd!"));
    }

}