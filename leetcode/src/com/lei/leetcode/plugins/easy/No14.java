package com.lei.leetcode.plugins.easy;

/**
 * @Author: zhang lei
 * @DateTime: 2022/5/9 13:24
 */
public class No14 {
    public static void main(String[] args) {

    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int strCount = strs.length;
        //第一个字符串遍历
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            //字符串数组数量
            for (int j = 0; j < strCount; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    //不相等时，就返回前面的就ok
                    return strs[0].substring(0, i);
                }
            }
        }
        //说明都相等，不用搞
        return strs[0];
    }
}
