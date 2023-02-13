package com.lei.od;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 生成了
 * N个1到500之间的随机整数。删去其中重复的数字，即相同的数字只保留一个，把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出
 */
public class Hj3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        Set<Integer> set = new TreeSet<>();
        for(int i = 0; i < sum; i++) {
            int anInt = in.nextInt();
            set.add(anInt);
        }
        for (Integer integer : set) {
            System.out.println(integer);
        }
    }
}
