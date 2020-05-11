package com.chaka.algorithms.stack;

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

    }

}