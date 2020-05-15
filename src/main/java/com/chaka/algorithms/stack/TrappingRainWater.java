package com.chaka.algorithms.stack;

import java.util.Stack;

/**
 * 接雨水
 *  1、双指针
 *  2、栈
 */
public class TrappingRainWater {

    public static int trap(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int low = height[stack.pop()];
                while (!stack.isEmpty() && height[stack.peek()] == low) {//存在高度相等的，都要pop掉
                    stack.pop();
                }
                res += stack.isEmpty() ? 0 : (Math.min(height[stack.peek()], height[i]) - low) * (i - stack.peek() - 1);
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(TrappingRainWater.trap(new int[]{2,1,0,2}));
    }

}
