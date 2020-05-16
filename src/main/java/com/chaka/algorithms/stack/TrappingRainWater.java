package com.chaka.algorithms.stack;

import java.util.Stack;

/**
 * 接雨水
 *  1、双指针
 *  public static int trap(int[] height) {
 *         int left = 0;
 *         int right = height.length - 1;
 *         int result = 0;
 *         int leftMax = 0;
 *         int rightMax = 0;
 *         while (left <= right){
 *             if (leftMax <= rightMax){
 *                 result += leftMax - height[left] > 0 ?
 *                         leftMax - height[left] : 0;
 *                 leftMax = Math.max(leftMax,height[left]);
 *                 left++;
 *             }else {
 *                 result += rightMax - height[right] > 0 ?
 *                         rightMax - height[right] : 0;
 *                 rightMax = Math.max(rightMax,height[right]);
 *                 right--;
 *             }
 *         }
 *         return result;
 *     }
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
        System.out.println(TrappingRainWater.trap(new int[]{2, 1, 0, 2}));
    }

}