package com.chaka.algorithms.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode-cn.com/problems/reverse-words-in-a-string/">翻转字符串里的单词</a>
 *  1、双端队列
 *  2、双指针
 */
public class ReverseWordsInAString {

    public String reverseWords(String s) {
        int start = 0;
        Deque<String> deque = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();
        while(start < s.length()){
            char c = s.charAt(start);
            if (c == ' '){
                //空
                if (word.length() > 0){
                    deque.offerFirst(word.toString());
                    word.delete(0,word.length());
                }
            }else {
                word.append(c);
                if (start == s.length() - 1){
                    deque.offerFirst(word.toString());
                }
            }
            start++;
        }
        return String.join(" ",deque);
    }

    public static void main(String[] args) {
        ReverseWordsInAString solve = new ReverseWordsInAString();
        System.out.println(solve.reverseWords("the sky is blue    "));
    }

}
