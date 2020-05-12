package com.chaka.algorithms.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 滑动窗口最大值
 *  1、双端队列
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(k);
        int ri = 0;
        for (int i = 0; i < nums.length; i++) {
            //移除非窗口内的值
            while (!deque.isEmpty() && deque.peek() < i - k + 1){
                deque.pop();
            }
            //移除窗口内比当前值小的值
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            //只有小的才会被追加到队尾中
            deque.offer(i);
            if (i >= k - 1) {
                res[ri++] = nums[deque.peek()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] ints = slidingWindowMaximum.maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

}