package com.chaka.algorithms.advanced_dynamic_program;

import java.util.Stack;

/**
 * <a href="https://leetcode-cn.com/problems/longest-valid-parentheses/">最长有效括号</a>
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '('){
                stack.push(i);
            }else {
                stack.pop();
                if (stack.empty()){
                    stack.push(i);
                }else {
                    max = Math.max(max,i - stack.peek());
                }
            }
        }
        return max;
    }

}

/*
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if (s == null || s.equals("")){
            return 0;
        }
        char[] chars = s.toCharArray();
        char[] tails = new char[chars.length + 1];
        char next = ' ';
        int idx = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != next){
                next = '(';
                idx = 0;
            }
            if (chars[i] == next){
                tails[idx++] = chars[i];
                next = next == ')' ? '(' : ')';
            }
        }

        int count = 0;
        for (char tail : tails) {
            if (tail == 0) {
                break;
            }
            count++;
        }
        if (count > 0){
            return tails[count-1] == ')' ? count : count - 1;
        }else {
            return 0;
        }
    }

}*/

