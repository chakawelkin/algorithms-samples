package com.chaka.algorithms.dynamic_program;

import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/triangle/">三角形最小路径和</a>
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int sum = 0;
        for (int i = 0; i < triangle.size(); i++) {
            sum += Collections.min(triangle.get(i));
        }
        return sum;
    }

}