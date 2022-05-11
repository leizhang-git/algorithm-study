package com.lei.leetcode.plugins.easy;

/**
 * @Author: zhang lei
 * @DateTime: 2022/5/11 15:34
 */
public class No69 {
    public static void main(String[] args) {

    }

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }
}
