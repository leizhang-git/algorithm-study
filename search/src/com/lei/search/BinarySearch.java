package com.lei.search;

/**
 * 二分查找正常实现
 * @author zhanglei
 * @date 2021/10/24 下午7:36
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,9,10,14,16,22,34,44,55};
        System.out.println(rank(34, arr));
    }

    //二分查找数组必须是有序的
    public static int rank(int key, int[] arr) {
        int le = 0;
        int re = arr.length - 1;

        while (le <= re) {
            int mid = le + (re - le) / 2;
            if(key < arr[mid]) {
                re = mid - 1;
            }else if (key > arr[mid]) {
                le = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
