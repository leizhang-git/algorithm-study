package com.lei.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 选择排序属于内部排序，不稳定排序
 * 平均复杂度O(n ^ 2) 最好情况O(n ^ 2) 最坏情况O(n ^ 2)
 */
public class SelectSortService {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for(int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() * 8000000);        //生成一个[0, 8000000)的数
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是 ：" + date1Str);
        selectSort(arr);
        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是 ：" + date2Str);
    }

    /**
     * 选择排序：
     * 两两对比，每次找最小
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            //设置最小值索引（假设第一个最小）
            int minIndex = i;
            int min = arr[i];
            for(int j = i + 1; j < arr.length; j++) {
                if(min > arr[j]) {  //找到比假定最小值还要小点值了
                    min = arr[j];
                    minIndex = j;
                }
            }
            //将最小值放入前面
            if(minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
