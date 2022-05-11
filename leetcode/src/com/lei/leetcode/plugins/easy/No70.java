package com.lei.leetcode.plugins.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: zhang lei
 * @DateTime: 2022/5/11 16:05
 */
public class No70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

    //f(x) = f(x-1) + f(x-2)
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
