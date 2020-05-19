package com.chaka.algorithms.hash;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index;
            if ((index = map.get(target - nums[i])) != null){
                return new int[]{index,i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

}