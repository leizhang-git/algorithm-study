package com.lei.od;

import java.util.Scanner;

/**
 * 输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 */
public class Hj6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        getPrimeFactor(target);
    }


    public static void getPrimeFactor(Integer num) {
        // 因子从2开始算
        int y = 2;
        // 短除法，除到目标值为1为止
        while (num != 1) {
            // 能能够整除2
            if(num % y == 0) {
                System.out.print(y+" ");
                num /= y;
            } else { // 更新y的值
                if (y > num / y) {
                    y = num;
                } else {
                    y++;
                }
            }
        }
    }

}
