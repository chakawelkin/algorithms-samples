package com.chaka.algorithms;

import com.chaka.algorithms.tree.node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null){
            return;
        }
        int i = 0,j = nums.length - 1;
        while (j > 0){
            //revers
            if (nums[j] > nums[j - 1]){
                //找到大于j-1的最后一个元素
                int k = j;
                while (k < nums.length && nums[k] > nums[j-1]){
                    k++;
                }
                swap(nums, j - 1, k-1);
                reverse(nums,j,nums.length-1);
                return;
            }
            j--;
        }
        reverse(nums,0,nums.length - 1);
    }

    private void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums,int i,int j){
        while (i < j){
            swap(nums,i++,j--);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        long i = 10106140046L;
        //2147483647
        //10106140046
        sol.nextPermutation(new int[]{1,3,2});
        System.out.println(Integer.MAX_VALUE);
        System.out.println(i > Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);

        TreeNode root = new TreeNode(1);

        Queue<TreeNode> queue = new LinkedList<TreeNode>(){
            {
                add(root);
            }
        };
    }

}