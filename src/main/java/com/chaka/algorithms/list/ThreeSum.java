package com.chaka.algorithms.list;

import java.util.*;

/**
 * 三数之和
 *  1、暴力法 排序 + 三循环
 * {@code public List<List<Integer>> threeSum(int[] nums) {
 *         Arrays.sort(nums);
 *         Set<List<Integer>> set = new LinkedHashSet<>();
 *         for (int i = 0; i < nums.length - 2; i++) {
 *             int a = nums[i];
 *             for (int j = i + 1; j < nums.length - 1; j++) {
 *                 int b = nums[j];
 *                 for (int k = j + 1; k < nums.length; k++) {
 *                     int c = nums[k];
 *                     if (a + b + c == 0) {
 *                         set.add(Arrays.asList(a, b, c));
 *                     }
 *                 }
 *             }
 *         }
 *
 *         return new ArrayList<>(set);
 *     }}
 *  2、排序 + 双指针 （左右夹逼法）
 *
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 ) break; // 结束，后面的无需遍历
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 存在相同的，可以先忽略
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0){
                    lists.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]){//去重操作
                        L++;
                    }
                    while (L < R && nums[R] == nums[R - 1]){//去重操作
                        R--;
                    }
                    L++;
                    R--;
                }else if (sum < 0) {
                    L++;
                }else {
                    R--;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println(lists);
    }

}