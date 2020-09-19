package com.chaka.algorithms.advanced_dynamic_program;

import java.util.Stack;

/**
 * <a href="https://leetcode-cn.com/problems/maximal-rectangle/">最大矩形</a>
 * 可以直接借鉴最大矩形面积的思想来做
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0){
            return 0;
        }
        int maxArea = 0;
        int[] heights = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if(matrix[i][col] == '1'){
                    heights[col] += 1;
                }else {
                    heights[col] = 0;
                }
            }
            maxArea = Math.max(maxArea,largestRectangleArea(heights));
        }
        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
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

}