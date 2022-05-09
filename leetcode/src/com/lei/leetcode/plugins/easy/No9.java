package com.lei.leetcode.plugins.easy;

/**
 * @Author: zhang lei
 * @DateTime: 2022/5/9 13:09
 */
public class No9 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(123));
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        //赋值后对比即可 除以/ 扔掉后面的，保留前面  求余% 保留后面，扔掉前面
        int num = x;
        int newValue = 0;
        while (num != 0) {
            newValue = newValue * 10 + num % 10;
            num /= 10;
        }
        return x == newValue;
    }
}
