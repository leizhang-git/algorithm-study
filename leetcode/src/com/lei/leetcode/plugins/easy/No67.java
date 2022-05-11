package com.lei.leetcode.plugins.easy;

/**
 * @Author: zhang lei
 * @DateTime: 2022/5/11 13:39
 */
public class No67 {
    public static void main(String[] args) {

    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            sb.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            sb.append('1');
        }
        sb.reverse();

        return sb.toString();
    }
}
