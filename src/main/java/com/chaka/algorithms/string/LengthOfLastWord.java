package com.chaka.algorithms.string;

/**
 * <a href="https://leetcode-cn.com/problems/length-of-last-word">最后一个单词的长度</a>
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if(s == null){return 0;}
        int end = s.length() - 1;
        //去除最末尾的空格
        while (end >= 0 && s.charAt(end) == ' '){
            end--;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' '){
            start--;
        }
        return end - start;
    }

}