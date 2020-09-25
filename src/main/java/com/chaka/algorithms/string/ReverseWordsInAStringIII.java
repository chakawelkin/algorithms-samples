package com.chaka.algorithms.string;

/**
 * <a href="https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/">反转单词</a>
 */
public class ReverseWordsInAStringIII {

    public String reverseWords(String s) {
        int i = 0,j = 0;
        StringBuilder word = new StringBuilder();
        for (int idx = 0 ;idx < s.length();idx++){
            char c;
            if ((c = s.charAt(idx)) == ' '){
                if (j > i){
                    for (int k = j - 1; k >= i; k--) {
                        word.append(s.charAt(k));
                    }
                }
                word.append(c);
                i = idx + 1;
            }else {
                j = idx + 1;
            }
            if (idx == s.length() - 1 && j > i){
                for (int k = j - 1; k >= i; k--) {
                    word.append(s.charAt(k));
                }
            }
        }
        return word.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInAStringIII solve = new ReverseWordsInAStringIII();
        System.out.println(solve.reverseWords(" Let's take LeetCode contest "));
    }

}
