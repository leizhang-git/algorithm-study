package com.lei.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 快速排序（对冒泡排序改进，不稳定）
 * 平均复杂度O(n logn)  最好(n logn)  最坏(n ^ 2)
 * @author zhanglei
 * @date 2021/10/24 下午9:53
 */
public class QuickSortService {

    public static void main(String[] args) {
        int[] arr = new int[8000000];
        for(int i = 0; i < 8000000; i++) {
            arr[i] = (int)(Math.random() * 800000000);        //生成一个[0,8000000) 数
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是：" + format);
        quickSort(arr,0,arr.length - 1);
        Date date2 = new Date();
        String format1 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是：" + format1);
    }

    /**
     * 快速排序，空间换时间（通过一趟排序将数据分割为两部分）
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        int l = left;       //左下标
        int r = right;      //右下标
        //中轴
        int pivot = arr[(left + right) / 2];
        int temp = 0;       //临时变量,交换时使用
        while (l < r) {     //让pivot左右分隔开
            while (arr[l] < pivot) {    //在pivot左边一直找,找到一个大于等于pivot的值
                l += 1;
            }
            while (arr[r] > pivot) {    //在pivot右边一直找，找到小于等于pivot的值
                r -= 1;
            }
            //若成立，则说明左右已经分隔开
            if(l >= r) {
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //交换完毕若arr[l] == pivot 则 r--，前移
            if(arr[l] == pivot) {
                r -= 1;
            }
            //交换完毕若arr[r] == pivot 则 l++，后移
            if(arr[r] == pivot) {
                l += 1;
            }
        }
        //判断 若 l == r， 必须 l++，r--，否则栈溢出
        if(l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归
        if(left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if(right > l) {
            quickSort(arr,l,right);
        }
    }
}
