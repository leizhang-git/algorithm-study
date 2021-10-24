package com.lei.sort;

import java.util.Arrays;

/**
 * 堆排序
 * 均为O(nlogn) 不稳定排序
 * @author zhanglei
 * @date 2021/10/24 下午10:44
 */
public class HeapSortService {

    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
        System.out.println("排序后 = " + Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        int temp = 0;
        System.out.println("堆排序");
        //将无序序列构建成一个堆，根据升序降序需求选择大项堆货小项堆
        for(int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        //将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端
        //重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序
        for(int j = arr.length - 1; j > 0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0, j);
        }
    }

    //将数组转换为最大堆
    /**
     * 功能：完成将以 i 为对应的非叶子结点的树调整成大项堆
     * eg：int[] arr = {4, 6, 8, 5, 9} => i = 1 => adjustHeap => 得到 {4, 9, 8, 5, 6}
     * 若再次调入 adjustHeap 则传入的是 i = 0 => 得到 {4, 9, 8, 5, 6} => {9, 6, 8, 5, 4}
     * @param arr 待调整的数组
     * @param i 表示非叶子结点在数组中索引
     * @param length 表示对多少个元素继续调整，length是在逐渐的减少
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];  //先取出当前元素的值，保存在临时变量
        //1.k = i * 2 + 1，k是 i 结点的左子结点
        for(int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if(k + 1 < length && arr[k] < arr[k + 1]) { //说明左子结点的值小于右子结点的值
                k++;    //k指向右子结点
            }
            if(arr[k] > temp) { //如果子结点大于父结点
                arr[i] = arr[k];    //把较大的值赋给当前结点
                i = k;  //指向k，继续循环比较
            }else {
                break;
            }
        }
        //当for 循环结束后，我们已经将以 i 为父结点的树的最大值，放在了最顶
        arr[i] = temp;  //将 temp 值放到调整后的位置
    }
}
