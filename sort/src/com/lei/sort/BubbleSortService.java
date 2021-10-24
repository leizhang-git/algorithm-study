package com.lei.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 冒泡排序（稳定）
 * 平均复杂度O(n ^ 2)  最好情况O(n)   最坏情况O(n ^ 2)
 * @author zhanglei
 * @date 2021/10/24 下午9:46
 */
public class BubbleSortService {

    public static void main(String[] args) {
        int[] arr = new int[80000];
        for(int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random()* 8000000);     //生成一个[0, 8000000)的数
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是 :" + date1Str);
        bubbleSort(arr);
        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是 :" + date2Str);
    }

    /**
     * 冒泡排序 找最大
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        //冒泡排序的时间复杂度O(n^2)
        int temp = 0;   //临时变量
        boolean flag = false;   //标识变量，表示是否进行过交换
        for(int i = 0; i < arr.length - 1; i++) {   //共进行n-1躺排序
            for(int j = 0; j < arr.length - 1 - i; j++) {   //共比较 n - 1 - i 次比较
                //若前面的数大于后面的数，则交换
                if(arr[j] > arr[j + 1]) {
                    flag = true;        //若交换，则 将flag的值设置为true
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if(!flag) { //说明此躺排序没发生过交换
                break;
            }else {
                flag = false;   //重置flag让其进行下次判断
            }
        }
    }
}
