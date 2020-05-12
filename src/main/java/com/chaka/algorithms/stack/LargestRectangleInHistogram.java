package com.chaka.algorithms.stack;

import java.util.Stack;

/**
 * 柱状图中最大矩形
 *  1、双指针(左右) 暴力法n^2复杂度
 *     {@code
 *      public int largestRectangleArea(int[] heights) {
 *         if (heights == null || heights.length < 1){
 *             return 0;
 *         }
 *         int area = 0;
 *         for (int i = 0; i < heights.length; i++) {
 *             int minHeight = heights[i];
 *             for (int j = i; j < heights.length; j++) {
 *                 minHeight = Math.min(minHeight,heights[j]);
 *                 area = Math.max(area,(j - i + 1) * minHeight);
 *             }
 *         }
 *         return area;
 *     }
 *     }
 *  2、栈
         */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            if (stack.peek() == -1 || heights[i] >= heights[stack.peek()]){
                stack.push(i);
            }else {
                // 不能存储值，需要存储值对应的坐标。。。。
                while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                    int area = heights[stack.pop()] * (i - stack.peek() - 1);
                    maxArea = Math.max(maxArea, area);
                }
                stack.push(i);
            }
        }

        //注：1、栈底存储的是当前最小边界
        //    2、当栈里只剩下除-1以外的本身后，此时，本身就是最小边界，这时面积计算就可以是整个宽度
        while (stack.peek() != -1){
            int area = heights[stack.pop()] * (heights.length -  stack.peek() - 1);
            maxArea = Math.max(maxArea,area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram histogram = new LargestRectangleInHistogram();
        histogram.largestRectangleArea(new int[]{6,7,5,2,4,5,9,3});
    }

}