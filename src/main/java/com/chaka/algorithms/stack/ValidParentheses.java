package com.chaka.algorithms.stack;

import java.util.Stack;

/**
 * 有效的括号
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if(s == null)return true;
        Stack<Character> stack = new Stack<>();
        for (char ele : s.toCharArray()) {
            if (ele == '('){
                stack.push(')');
            }else if (ele == '['){
                stack.push(']');
            }else if (ele == '{'){
                stack.push('}');
            }else {
                if (stack.empty() || stack.pop() != ele) {
                    return false;
                }
            }
        }
        return stack.empty();

    }

    /*public static void main(String[] args) {
        ValidParentheses parentheses = new ValidParentheses();
        System.out.println(parentheses.isValid("()[]{}"));
    }*/

}
