package com.lei.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 基数排序
 * @author zhanglei
 * @date 2021/10/24 下午11:07
 */
public class RadixSortService {

    public static void main(String[] args) {
        int[] arr = new int[8000000];
        for(int i = 0; i < 8000000; i++) {
            arr[i] = (int)(Math.random() * 800000000);        //生成一个[0,8000000) 数
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是：" + format);
        radixSort(arr);
        Date date2 = new Date();
        String format1 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是：" + format1);
    }

    public static void radixSort(int[] arr) {
        //得到数组中最大的数的位数
        int max = arr[0];
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        //得到最大数是几位数
        int maxLength = (max + "").length();
        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        //1.二维数组包含10个一维数组
        //2.防止溢出，每一个一维数组，大小定位arr.length
        //3.基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];
        //为了记录每个桶中，实际存放了多少个数据，我们定义一个一维数组来记录各个桶的每次放入的数据个数\
        int[] bucketElementCounts = new int[10];
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //针对每个元素的对应位进行排序处理，第一个为个位、第二个是百位...
            for (int value : arr) {
                //取出每个元素的对应位的值
                int digitOfElement = value / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = value;
                bucketElementCounts[digitOfElement]++;
            }
            //按照这个桶排序（一维数组的下标依次取出数据，放入原来数组）
            int index = 0;
            //遍历每一桶，并将桶中是数据，放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中，有数据，我们才放入原数组
                if(bucketElementCounts[k] != 0) {
                    //循环该桶即第k个桶（即第k个一维数组），放入
                    for (int l = 0; l < bucketElementCounts[k]; l++){
                        //取出元素放入到arr
                        arr[index++] = bucket[k][l];
                    }
                }
                //第 i + 1轮 处理后，需要将每个 bucketElementCounts[k] = 0
                bucketElementCounts[k] = 0;
            }
            //System.out.println("第" + (i + 1) + "轮，对个位的排序处理 arr=" + Arrays.toString(arr))
        }
    }
}
