package com.chaka.algorithms.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 最小的k个数
 *  1、快排
 *  2、
 */
public class ZuiXiaoDeKgeShuLcof {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || k < 1){
            return new int[]{};
        }
        // 创建一个大顶堆
        Queue<Integer> queue = new PriorityQueue<>((v1,v2) -> v2 - v1);
        for (int i : arr) {
            if (queue.size() < k){
                queue.offer(i);
            }else if (i < queue.peek()){//小于最大的，那么就把最大的替换掉
                queue.poll();
                queue.offer(i);
            }
        }
        int[] res = new int[queue.size()];
        int idx = 0;
        for (Integer ele : queue) {
            res[idx++] = ele;
        }
        return res;
    }

}
