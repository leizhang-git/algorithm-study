package com.leiz.stack;

import java.util.Scanner;
import java.util.Stack;
/**
 * 计算器
 * 操作数压入数字栈
 * 运算符压入运算符栈
 * 忽略左括号
 * 遇到右括号，弹出一个运算符，弹出所需数量的操作数，且将运算结果入数字栈
 * @author zhanglei
 * @date 2021/10/24 下午7:50
 */
public class Envaluate {
    public static void main(String[] args) {

        String str = "(1+((2+3)*(4*5)))";

        //符号栈
        Stack<Character> ops = new java.util.Stack<Character>();
        //数字栈
        Stack<Double> vals = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {

            }else if(str.charAt(i) == '+') {
                ops.push(str.charAt(i));
            }else if(str.charAt(i) == '-') {
                ops.push(str.charAt(i));
            }else if(str.charAt(i) == '*') {
                ops.push(str.charAt(i));
            }else if(str.charAt(i) == '/') {
                ops.push(str.charAt(i));
            }else if(str.charAt(i) == ')') {
                Character op = ops.pop();
                Double v = vals.pop();
                if(op == '+') {
                    v = vals.pop() + v;
                }else if(op == '-') {
                    v = vals.pop() - v;
                }else if(op == '*') {
                    v = vals.pop() * v;
                }else if(op == '/') {
                    v = vals.pop() / v;
                }
                vals.push(v);
            }else {
                vals.push(Double.parseDouble(String.valueOf(str.charAt(i))));
            }
        }
        System.out.println(vals.pop());
    }
}
