package com.lei.leetcode.plugins.easy;

import java.util.Arrays;

/**
 * @Author: zhang lei
 * @DateTime: 2022/5/9 15:44
 */
public class No27 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 2};
        String s = Arrays.toString(arr);
        System.out.println(removeElement(arr, 2) + "-" + s);
    }



    //双指针
    public static int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if(nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            }else {
                left++;
            }
        }
        return left;
    }
}
