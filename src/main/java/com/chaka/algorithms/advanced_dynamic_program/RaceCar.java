package com.chaka.algorithms.advanced_dynamic_program;

/**
 * <a href="https://leetcode-cn.com/problems/race-car/">赛车</a>
 */
public class RaceCar {

    public int racecar(int target) {
        int[] dp = new int[target + 1];
        for (int i = 1; i <= target; i++) {
            dp[i] = Integer.MAX_VALUE;
            int cnt1 = 1, j = 1;
            //正向加速到达的位置为j，正向加速的次数为cnt1
            for (; j < i; j = (1 << ++cnt1) - 1) {
                //对于每个位置j，都进行反跑，反向加速位置从0开始，不能超过j，那么正向就走了j-k
                for (int k =0,cnt2 = 0; k < j; k = (1 << ++cnt2) - 1){
                    dp[i] = Math.min(dp[i],cnt1 + 1 + cnt2 + 1 + dp[i - (j-k)]);
                }
            }
            //接下来是超过位置i才回头的情况
            dp[i] = Math.min(dp[i],cnt1 + (i == j ? 0 : 1 + dp[j - i]));
        }

        return dp[target];
    }

}