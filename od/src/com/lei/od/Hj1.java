package com.lei.od;

import java.util.Scanner;

/**
 * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000
 */
public class Hj1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String scn = in.nextLine();
        Integer length = getLength(scn);
        System.out.println(length);
    }

    public static Integer getLength(String str) {
        if(null != str && str.length() > 0) {
            String[] s = str.split(" ");
            if(s.length > 0) {
                return s[s.length - 1].length();
            }
        }
        return null;
    }
}
