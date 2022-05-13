package com.lei.leetcode.plugins.easy;

import java.util.Arrays;

/**
 * @Author: zhanglei
 * @DateTime: 2022/5/13 10:18
 */
public class No88 {

    public static void main(String[] args) {

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i != n; ++i) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
