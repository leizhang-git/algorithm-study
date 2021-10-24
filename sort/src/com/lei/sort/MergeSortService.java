package com.lei.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 归并排序（稳定排序）
 * 平均时间复杂度O(nlogn)  最好O(nlogn)  最坏O(n)
 * 空间复杂度O(n) 需要占额外内存
 * @author zhanglei
 * @date 2021/10/24 下午9:57
 */
public class MergeSortService {

    public static void main(String[] args) {
        int[] arr = new int[8000000];
        for(int i = 0; i < 8000000; i++) {
            arr[i] = (int)(Math.random() * 800000000);        //生成一个[0,8000000) 数
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是：" + format);
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        Date date2 = new Date();
        String format1 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是：" + format1);
    }


    //分 + 合方法
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if(left < right) {
            int mid = (left + right) / 2;   //中间索引
            //向左递归进行分解
            mergeSort(arr,left, mid, temp);
            //向右递归进行分解
            mergeSort(arr,mid + 1, right, temp);
            //合并
            merge(arr,left,mid,right,temp);
        }
    }


    /**
     * 合并
     * @param arr   排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  做中转的数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;       //初始化i，左边有序序列的初始索引
        int j = mid + 1;    //初始化j，右边有序序列的初始索引
        int t = 0;          //指向temp数组的当前索引
        //先把左右两边(有序)的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {//继续
            //若左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            //即将左边的当前元素，填充到temp数组
            //然后 t++，i++
            if(arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            }else { //反之，将右边有序序列的当前元素，填充到temp数组
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }
        //把有剩余数据的一边的数据一次全部填充到temp
        while (i <= mid) {  //左边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while (j <= right) {    //右边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }
        //将temp数组的元素拷贝到arr
        //注意：并不是每次都拷贝
        t = 0;
        int tempLeft = left;
        //第一次合并 tempLeft = 0, right = 1 // tempLeft = 2 right = 3 // tL = 0 ri = 3
        //最后一次 tempLeft = 0 right = 7
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }
}
