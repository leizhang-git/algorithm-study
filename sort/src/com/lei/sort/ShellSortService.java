package com.lei.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 希尔排序(属于插入排序)
 * @author zhanglei
 * @date 2021/10/24 下午10:34
 */
public class ShellSortService {

    public static void main(String[] args) {
        int[] arr = new int[80000];
        for(int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() * 8000000);        //生成一个[0, 8000000)的数
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是 ：" + date1Str);
        shellSort(arr);
        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是 ：" + date2Str);
    }

    public static void shellSort(int[] arr) {
        int temp = 0;
        int count = 0;
        for(int gap = arr.length / 2; gap > 0; gap /= 2) {
            for(int i = gap; i < arr.length; i++) {
                //遍历各组中所有的元素(共gap组，每组有的元素，步长gap)
                for(int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素大于加上步长后的那个元素，说明交换
                    if(arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    /**
     * 移位法
     * @param arr
     */
    public static void shellSort2(int[] arr) {
        for(int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个插入
            for(int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if(arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //退出时，便找到
                    arr[j] = temp;
                }
            }
        }
    }
}
