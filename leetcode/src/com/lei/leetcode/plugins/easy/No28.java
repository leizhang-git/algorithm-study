package com.lei.leetcode.plugins.easy;

/**
 * @Author: zhang lei
 * @DateTime: 2022/5/9 16:09
 */
public class No28 {
    public static void main(String[] args) {

    }

    /**
     *
     * @param haystack 原串
     * @param needle 后串
     * @return
     */
    public int strStr (String haystack, String needle) {
        int commonStrLength = haystack.length();
        int childStrLength = needle.length();
        if (childStrLength == 0) {
            return 0;
        }
        int[] childArr = new int[childStrLength];
        for (int i = 1, j = 0; i < childStrLength; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = childArr[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            childArr[i] = j;
        }
        for (int i = 0, j = 0; i < commonStrLength; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = childArr[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == childStrLength) {
                return i - childStrLength + 1;
            }
        }
        return -1;
    }
}
