package com.leiz.array;

/**
 * 稀疏数组
 * @Author: zhanglei
 * @Date: 2021/8/17 23:37
 */
public class SparseArray {

    public static void main(String[] args) {

        //创建一个二维数组
        int[][] arr = new int[11][11];

        /*
            00000
            00100
            00010
            00001
         */
        arr[1][2] = 1;
        arr[2][3] = 1;
        arr[4][5] = 1;

        int[][] sparseArray = sparseArray(arr);

        System.out.println("稀疏数组为：");
        for (int[] ints : sparseArray) {
            System.out.printf("%d\t%d\t%d\t\n", ints[0], ints[1], ints[2]);
        }
    }

    /**
     * 此方法用于将二维数组转换为稀疏数组
     * (当一个数组大部分元素为0，或者为同一个值的数组时，稀疏数组优势很大)
     * @param arr
     * @return
     */
    public static int[][] sparseArray(int[][] arr) {
        int sum = 0;
        //得到该二维数组非0的个数
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    sum++;
                }
            }
        }
        //创建稀疏数组(列固定为3 分别为 第几行 第几列 值为多少)
        int[][] sparseArr = new int[sum + 1][3];
        //稀疏数组第一行记录原数组的大小：多少行 多少列 多少个非0的数据(非固定值)
        sparseArr[0][0] = arr.length;
        sparseArr[0][1] = arr[0].length;
        sparseArr[0][2] = sum;
        //遍历二维数组，将非0的值放入稀疏数组
        int count = 0;  //用于记录二维数组非0的值
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = arr[i][j];
                }
            }
        }
        return sparseArr;
    }
}
