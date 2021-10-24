package com.lei.search;

import java.util.ArrayList;

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


    /**
     * 二分查找
     * @param arr 数组
     * @param left 左索引
     * @param right 右索引
     * @param findVal 要查找的数字
     * @return 返回其下标，没找到则返回 -1
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        //当left > right 时，说明数组已经递归完毕，但是还没有找到!
        if(left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if(findVal > midVal) {
            return binarySearch(arr, mid + 1, right, findVal);
        }else if(findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        }else {
            return mid;
        }
    }

    /**
     * 二分查找 加强版
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        //当left > right 时，说明数组已经递归完毕，但是还没有找到!
        if(left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if(findVal > midVal) {
            return binarySearch2(arr, mid + 1, right, findVal);
        }else if(findVal < midVal) {
            return binarySearch2(arr, left, mid - 1, findVal);
        }else {
            //此时不能直接返回，而是向两侧分别查询
            ArrayList<Integer> list = new ArrayList<>();
            int temp = mid - 1;
            while (temp >= 0 && arr[temp] == findVal) {
                //找到，放入集合
                list.add(temp);
                temp -= 1;
            }
            temp = mid + 1;
            while (temp <= arr.length - 1 && arr[temp] == findVal) {
                list.add(temp);
                temp += 1;
            }
            return list;
        }
    }

    /**
     * 二分查找非递归实现
     * @param arr 数组，升序排序
     * @param target 要查找的数
     * @return 返回对应下标， -1表示没有找到
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == target) {
                return mid;
            }else if(arr[mid] > target) {
                right = mid - 1;        //向左继续查找
            }else {
                left = mid + 1;         //向右继续查找
            }
        }
        return -1;
    }
}
