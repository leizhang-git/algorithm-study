package com.lei.leetcode.plugins.easy;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author: zhang lei
 * @DateTime: 2022/5/9 13:57
 */
public class No20 {

    public static void main(String[] args) {

    }

    public boolean isValid(String s) {
        //奇数必错
        if(s.length() % 2 == 1) {
            return false;
        }
        //括号对
        Map<Character, Character> bracketPairs = new HashMap<Character, Character>() {
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //有关括号，则查找
            if(bracketPairs.containsKey(ch)) {
                //peek 不会改变栈的值(不删除栈顶的值)         pop会把栈顶的值删除
                //从内向外找！
                if(stack.isEmpty() || stack.peek() != bracketPairs.get(ch)) {
                    return false;
                }
                //删除
                stack.pop();
            }else {
                //入栈
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
