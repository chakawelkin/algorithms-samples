package com.chaka.algorithms.list;

/**
 * 移动零
 * 1、两套循环
 * 2、双指针
 *    -- 先将所有非0的元素遍历出后依次放到数组最左边，剩下的全补0
 * 3、快慢指针(最优解)
 *    --
 */
public class MoveZeros {


    public void moveZeroes(int[] nums) {
        /*int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[j++] = nums[i];
            }
        }

        for (;j < nums.length;j++){
            nums[j] = 0;
        }*/

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                if (i == j){ // 当指针在同一位置时，无需交换
                    j++;
                }else {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j++] = temp;
                }
            }
        }
    }



}