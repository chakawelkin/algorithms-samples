package com.chaka.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode-cn.com/problems/combinations/">组合</a>
 *  给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class Combinations {

    private List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        reCombine(n,k,1,new Stack<>());
        return list;
    }

    public void reCombine(int n, int k, int begin, Stack<Integer> stack){
        if (k == stack.size()){
            list.add(new ArrayList<>(stack));
            return;
        }
        //这个地方需要剪枝
        for (int i = begin; i <= n && (k - stack.size()) <= n + 1 - i; i++) {
            stack.push(i);
            reCombine(n,k,i + 1,stack);
            stack.pop();
        }

    }

}