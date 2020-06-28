package com.chaka.algorithms.divide_conquer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode-cn.com/problems/subsets/">子集</a>
 */
public class Subsets {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backTrack(0,nums,new Stack<>());
        return result;
    }

    public void backTrack(int i,int[] nums, Stack<Integer> stack){
        result.add(new ArrayList<>(stack));
        for (int j = i; j < nums.length; j++) {
            stack.push(nums[j]);
            backTrack(j + 1,nums,stack);
            stack.pop();
        }
    }

}