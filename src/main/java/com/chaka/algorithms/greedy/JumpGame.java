package com.chaka.algorithms.greedy;

/**
 * <a href="https://leetcode-cn.com/problems/jump-game/">跳跃游戏</a>
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightMost = 0; //能到的最远距离
        for (int i = 0; i < n; i++) {
            if (i <= rightMost){
                rightMost = Math.max(rightMost,i + nums[i]);
                if (rightMost >= n - 1){
                    return true;
                }
            }
        }
        return false;
    }

}
