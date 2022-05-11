package com.lei.leetcode.plugins.easy;

/**
 * @Author: zhang lei
 * @DateTime: 2022/5/11 13:33
 */
public class No66 {
    public static void main(String[] args) {

    }

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            //否则是9结尾
            if(digits[i]!=0) {
                return digits;
            }
        }
        //给一个新数组
        digits = new int[len + 1];
        //第一位设置1
        digits[0] = 1;
        return digits;
    }
}
