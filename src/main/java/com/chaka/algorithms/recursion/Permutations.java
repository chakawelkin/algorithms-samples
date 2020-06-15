package com.chaka.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 全排列
 */
public class Permutations {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
       boolean[] used = new boolean[nums.length];
       rePermute(nums,used,new Stack<>());
       return res;
    }

    public void rePermute(int[] nums, boolean[] used, Stack<Integer> stack){
        if (nums.length == stack.size()){
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]){
                used[i] = true;
                stack.push(nums[i]);
                rePermute(nums,used,stack);
                stack.pop();
                used[i] = false;
            }
        }
    }

}