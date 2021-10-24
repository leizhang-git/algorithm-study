package com.leiz.queue;

/**
 * 队列（从右向左）
 * 1    2    3    4    5
 * 头指针               队尾指针
 * @author zhanglei
 * @date 2021/10/24 下午9:19
 */
public class Queue {
    private int maxSize;        //数组最大容量
    private int queueFront;     //指向队列头部的指针（第一个元素）
    private int queueRear;      //指向队列尾部的指针（最后一个元素的后一个元素）

    private int[] queueArr;     //模拟队列

    public Queue(int queueMaxSize) {
        maxSize = queueMaxSize;
        queueArr = new int[maxSize];
    }

    //判断队列满
    public boolean isFull() {
        return (queueRear + 1) % maxSize == queueFront;
    }

    //判断队列空
    public boolean isEmpty() {
        return queueRear == queueFront;
    }

    //入队
    public void addQueue(int n) {
        //判断队列是否满
        if(isFull()) {
            System.out.println("队列满，无法添加数据");
            return;
        }
        queueArr[queueRear] = n;
        //rear后移,其索引小于max，每次取模加1
        queueRear = (queueRear + 1) % maxSize;
    }

    //出队
    public int getQueue() {
        //判断队列是否为空
        if(isEmpty()) {
            throw new RuntimeException("队列空");
        }
        //front作为指针，将其后移一位
        //将front对应的值保留到一个临时变量
        int value = queueArr[queueFront];
        queueFront = (queueFront + 1) % maxSize;
        return value;
    }

    //当前队列有效数据个数
    public int queueSize() {
        //其实尾指针索引就是长度
        return (queueRear + maxSize - queueFront) % maxSize;
    }

    //list
    public void showQueue() {
        //判断空
        if(isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        //front开始遍历
        for(int i = queueFront; i < queueFront + queueSize() % maxSize; i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, queueArr[i % maxSize]);
        }
    }

    //显示队列头数据
    public int headQueue() {
        if(isEmpty()) {
            throw new RuntimeException("队列空");
        }
        return queueArr[queueFront];
    }
}
