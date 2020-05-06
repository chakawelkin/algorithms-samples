package com.chaka.algorithms.list;

/**
 * 盛水最多的容器
 * 1、暴力循环法 （两个循环）
 * 2、双指针法 (左右指针)
 */
public class MostWaterContainer {

    //todo 代码精简化
    public int maxArea(int[] height) {
        int area = 0;
        int l = 0;
        int r = height.length - 1;//右指针
        while (l != r) {
            int tmpArea;
            int i = height[l];
            int j = height[r];
            if (Math.min(i,j) == i){
                tmpArea = i * (r - l++);
            }else {
                tmpArea = j * (r-- - l);
            }
            area = Math.max(tmpArea, area);
        }
        return area;
    }

}