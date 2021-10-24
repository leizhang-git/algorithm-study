package com.lei.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 插入排序（稳定）
 * 平均复杂度O(n ^ 2)  最好情况O(n)  最坏情况O(n ^ 2)
 * @author zhanglei
 * @date 2021/10/24 下午9:49
 */
public class InsertSortService {

    public static void main(String[] args) {
        int[] arr = new int[80000];
        for(int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() * 8000000);        //生成一个[0,8000000) 数
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是：" + format);
        insertSort(arr);
        Date date2 = new Date();
        String format1 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是：" + format1);
    }

    /**
     * 插入排序（把n个待排序的元素看成一个有序表和一个无序表）
     * @param arr
     */
    public static void insertSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];         //要插入的数（第二个列表的首位）
            int insertIndex = i - 1;        //要插入数的前一个数的下标（第一个列表的末尾的编号）
            //注：第一个列表是有序的
            //insertIndex > 0 保证 插入的位置不越界
            //insertVal < arr[insertIndex] 说明 要插入的数还没有找到插入的位置，否则它正常加入到最后即可
            //接着将 arr[insertIndex] 后移
            while(insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //退出while循环时，说明插入的位置找到，insertIndex + 1
            arr[insertIndex + 1] = insertVal;
        }
    }
}
