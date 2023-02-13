package com.lei.od;

import java.util.Scanner;

/**
 * 接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于 0.5 ,向上取整；小于 0.5 ，则向下取整
 */
public class Hj7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double aDouble = sc.nextDouble();
        System.out.println(getNumber(aDouble));
    }

    public static Integer getNumber(double in) {
        int value = (int) in;
        double tmp = in - (int) in;
        if(tmp >= 0.5) {
            return value + 1;
        }else {
            return value;
        }
    }
}
