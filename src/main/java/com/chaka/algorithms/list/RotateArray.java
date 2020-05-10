package com.chaka.algorithms.list;

/**
 * 旋转数组 （要求空间复杂度为O(1)）
 *  1、暴力求解
 *  2、环状替换
 *  3、反转
 *      先将数组反转后，在从K位置隔开单独进行子数组的反转即可
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        if (nums.length < 2 || k < 1){
            return;
        }
        int count = 0;
        //环状替换
        for (int i = 0; count < nums.length; i++) {
            int curr = i;
            int prev = nums[curr];
            while (true){
                int next = (curr + k) % nums.length;
                int tmp = nums[next];
                nums[next] = prev;
                prev = tmp;
                curr = next;
                count++;
                if (i == curr){
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(new int[]{1,2,3,4,5,6,7},3);
    }

}