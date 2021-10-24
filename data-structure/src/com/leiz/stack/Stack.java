package com.leiz.stack;

/**
 * @author zhanglei
 * @date 2021/10/24 下午7:49
 */
public class Stack {

    //栈的大小
    private int maxSize;

    //栈
    private int[] stack;

    //栈顶
    private int stackTop = 0;

    //栈构造器
    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull() {
        return stackTop == maxSize;
    }

    //栈空
    public boolean isEmpty() {
        return stackTop == 0;
    }

    //入栈
    public void push(int value) {
        //判断栈是否满
        if(isFull()) {
            System.out.println("栈满");
            return;
        }
        stack[stackTop] = value;
        //注意，每入一次栈，栈顶指针都+1，则相当于其在队伍的前一位
        /*
         *      1   2   3   4
         *                      栈顶指针
         */
        stackTop++;
    }

    //出栈
    public int pop() {
        //判断栈是否空
        if(isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int value = stack[stackTop];
        stackTop--;
        return value;
    }

    //显示，栈顶在左侧
    public void list() {
        if(isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for(int i = stackTop; i > 0; i--) {
            System.out.printf("stack[%d] = %d\n", i - 1, stack[i - 1]);
        }
    }
}
