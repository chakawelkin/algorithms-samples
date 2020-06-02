package com.chaka.algorithms.heap;

import java.util.*;

/**
 * 前 K 个高频元素
 *  1、hash + 最小堆
 *  {@code public int[] topKFrequent(int[] nums, int k) {
 *         if (nums == null || k < 0){
 *             return new int[]{};
 *         }
 *         final Map<Integer,Integer> map = new HashMap<>();
 *         for (int num : nums) {
 *             Integer val;
 *             if ((val = map.get(num)) == null){
 *                 map.put(num,1);
 *             }else {
 *                 map.put(num,val + 1);
 *             }
 *         }
 *
 *         PriorityQueue<Integer> queue =
 *                 new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
 *
 *         map.forEach((key,value) -> {
 *             queue.offer(key);
 *             if(queue.size() > k){
 *                 queue.poll();//弹出最小的
 *             }
 *         });
 *
 *         int[] res = new int[queue.size()];
 *         for (int i = res.length - 1; i >= 0; i--) {
 *             res[i] = queue.poll();
 *         }
 *         return res;
 *     }}
 *  2、桶排序 时间复杂度
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || k < 0){
              return new int[]{};
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
              Integer val;
              if ((val = map.get(num)) == null){
                  map.put(num,1);
              }else {
                  map.put(num,val + 1);
              }
        }

        List<Integer>[] list = new List[nums.length + 1];
        map.forEach((key,value) -> {
            if (list[value] == null){
                list[value] = new ArrayList<>();
            }
            list[value].add(key);
        });

        int idx = 0;
        int[] res = new int[k];
        for (int i = list.length - 1; i >= 0 && idx < k; i--) {
            if (list[i] != null){
                for (Integer integer : list[i]) {
                    res[idx++] = integer;
                }
            }
        }
        return res;
    }

}
