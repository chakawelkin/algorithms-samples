package com.chaka.algorithms.dynamic_program;

import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/triangle/">三角形最小路径和</a>
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 1; i > 0 ; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size() - 1; j++) {
                List<Integer> upList = triangle.get(i - 1);
                upList.set(j, upList.get(j) + Math.min(list.get(j),list.get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }

}