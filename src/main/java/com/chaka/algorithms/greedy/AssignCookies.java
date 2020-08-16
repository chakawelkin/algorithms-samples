package com.chaka.algorithms.greedy;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/assign-cookies/description/">分发饼干</a>
 * 用最小的饼干满足胃口最小的孩子，从而达到尽可能满足最多的孩子
 */
public class AssignCookies {

    private int count = 0;

    private int idx = 0;//记录指针

    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null){
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0; i < g.length && idx < s.length; i++) {
            greedy(g[i],s);//优先满足胃口小的孩子
        }
        return count;
    }

    public void greedy(int g,int[] s){
        while (idx < s.length){
            if (s[idx++] >= g){
                count++;
                break;
            }
        }
    }

}