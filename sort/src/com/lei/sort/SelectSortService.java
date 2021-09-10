package com.lei.sort;

import java.util.Arrays;

public class SelectSortService {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 90, 123};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));
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
