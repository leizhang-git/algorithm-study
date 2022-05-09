package com.lei.leetcode.plugins.easy;

/**
 * @Author: zhang lei
 * @Date:2022/5/9 22:09
 */
public class No53 {
    public static void main(String[] args) {
        int[] nums = {-2, -1, -3, 4, -1, 2, 1, -5, 4};

    }

    //动态规划
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int maxAns = nums[0];
        for (int num : nums) {
            //核心所在！
            pre = Math.max(pre + num, num);
            //与第一个数比较！
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
