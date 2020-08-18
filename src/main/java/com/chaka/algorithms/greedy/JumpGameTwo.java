package com.chaka.algorithms.greedy;

/**
 * <a href="https://leetcode-cn.com/problems/jump-game-ii/">跳跃游戏 II</a>
 *
 * 该提 -- 假设是总是可以跳到最后的位置
 */
public class JumpGameTwo {

    public int jump(int[] nums) {
        int end = 0, rightMost=0, steps=0;
        //因为第一步的时候就已经记录了一次
        for (int i = 0; i < nums.length - 1; i++) {
            if (i <= rightMost){
                rightMost = Math.max(rightMost,i + nums[i]);
                if (i == end){//每次走最远的位置
                    end = rightMost;
                    steps++;
                }
            }
        }
        return steps;
    }

}
