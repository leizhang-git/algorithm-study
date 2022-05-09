package com.lei.leetcode.plugins.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhang lei
 * @Date: 2022/4/21 13:55
 */
public class No1 {
    
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] twoSum = new No1().twoSum(nums, target);
        System.out.println(Arrays.toString(twoSum));
    }

    public int[] twoSum(int[] nums, int target) {
        //value -> key 注意相反
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(result.containsKey(target - nums[i])) {
                return new int[]{result.get(target - nums[i]), i};
            }
            result.put(nums[i], i);
        }
        return null;
    }
}
