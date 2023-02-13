package com.lei.od;

import java.util.Scanner;

/**
 * 接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 */
public class Hj2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String scn = in.nextLine();
        char ch = in.next().charAt(0);
        Integer num = getNum(scn, ch);
        System.out.println(num);
    }

    /**
     * 直接比较
     * @param str
     * @param ch
     * @return
     */
    public static Integer getNum(String str, char ch) {
        if(null == str || str.length() == 0) {
            return 0;
        }
        int result = 0;
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if(Character.toLowerCase(aChar) == Character.toLowerCase(ch)) {
                result++;
            }
        }
        return result;
    }

    /**
     * 将传入的字符删除掉，在计算差值即可
     * @param str
     * @param ch
     * @return
     */
    public static Integer getNum1(String str, char ch) {
        if(null == str || str.length() == 0) {
            return 0;
        }
        int result = 0;
        String s = str.toUpperCase().replace(String.valueOf(ch).toUpperCase(), "");
        result = str.length() - s.length();
        return result;
    }
}
