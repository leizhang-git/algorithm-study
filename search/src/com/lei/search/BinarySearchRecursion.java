package com.lei.search;

/**
 * 二分查找 --- 递归实现
 * @author zhanglei
 * @date 2021/10/24 下午7:37
 */
public class BinarySearchRecursion {

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9};
        System.out.println(rank(7, arr, 0, arr.length - 1));
    }


    /**
     * 返回找到的索引
     * @param key 要查找的数字
     * @param arr 要查找的数组
     * @param le 左序列
     * @param re 右序列
     * @return 返回该数字的索引
     */
    public static int rank(int key, int[] arr, int le, int re) {
        //若key存在于arr[]中，它的索引不会小于le，且不会大于re
        if(le > re) {
            return -1;
        }
        int mid = le + (re - le) / 2;       //le:最左侧 + 距离 ==> 索引
        if(key < arr[mid]) {
            return rank(key, arr, le, mid - 1);
        }else if (key > arr[mid]) {
            return rank(key, arr, mid + 1, re);
        }else {
            return mid;
        }
    }

}
