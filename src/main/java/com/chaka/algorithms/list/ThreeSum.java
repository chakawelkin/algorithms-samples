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
 *  2、排序 + 双指针
 *
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 ) break; // 结束，后面的无需遍历
            if (nums[i + 1] == nums[i]) continue; // 存在相同的，可以先忽略

        }
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }

}