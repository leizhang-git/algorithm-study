package com.lei.od;

import java.util.*;

/**
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 */
public class Hj5 {

    public static final Map<String, String> numTabelMap;

    static {
        numTabelMap = new HashMap<>();
        numTabelMap.put("0", "0000");
        numTabelMap.put("1", "0001");
        numTabelMap.put("2", "0010");
        numTabelMap.put("3", "0011");
        numTabelMap.put("4", "0100");
        numTabelMap.put("5", "0101");
        numTabelMap.put("6", "0110");
        numTabelMap.put("7", "0111");
        numTabelMap.put("8", "1000");
        numTabelMap.put("9", "1001");
        numTabelMap.put("A", "1010");
        numTabelMap.put("B", "1011");
        numTabelMap.put("C", "1100");
        numTabelMap.put("D", "1101");
        numTabelMap.put("E", "1110");
        numTabelMap.put("F", "1111");
    }

    /**
     * 十六进制转二进制
     * @param hexNumber
     * @return
     */
    public static String hexadecimalToBinary(String hexNumber) {
        if(null == hexNumber || hexNumber.length() == 0) {
            return null;
        }
        StringBuilder binaryStr = new StringBuilder();
        for(int i = 0; i < hexNumber.length(); i++) {
            binaryStr.append(numTabelMap.get(String.valueOf(hexNumber.charAt(i))));
        }
        return binaryStr.toString();
    }

    /**
     * 简单用法,可以通过此方法直接转为10进制
     * @param hexNumber
     * @return
     */
    public static String text(String hexNumber) {
        if(null == hexNumber || hexNumber.length() == 0) {
            return null;
        }
        return String.valueOf(Integer.parseInt(hexNumber, 16));
    }

    /**
     * 二进制转十进制
     * @param binaryNumber
     * @return
     */
    public static Integer binaryToDecimalism(String binaryNumber) {
        double result = 0;
        int p = 0;
        for(int i = binaryNumber.length() - 1; i >= 0; i--) {
            result += Integer.decode(String.valueOf(binaryNumber.charAt(i))) * Math.pow(2, p);
            p++;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String scn = in.next();
        String binStr = hexadecimalToBinary(scn.substring(2));
        Integer integer = binaryToDecimalism(binStr);
        System.out.println(integer);
    }
}
