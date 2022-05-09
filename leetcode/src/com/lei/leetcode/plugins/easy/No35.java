package com.lei.leetcode.plugins.easy;

/**
 * @Author: zhang lei
 * @DateTime: 2022/5/9 16:17
 */
public class No35 {

    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
