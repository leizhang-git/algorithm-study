package com.lei.od;

import java.util.Scanner;

/**
 * •输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 */
public class Hj4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String scn = in.next();
        disStr(scn);
    }

    public static void disStr(String str) {
        if(str.length() == 8) {
            System.out.println(str);
            return;
        }
        while (str.length() >= 8) {
            System.out.println(str.substring(0, 8));
            str = str.substring(8);
        }
        if(str.length() != 0) {
            str = str + "00000000";
            str = str.substring(0, 8);
            System.out.println(str);
        }
    }


}
