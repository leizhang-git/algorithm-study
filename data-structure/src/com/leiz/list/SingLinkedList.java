package com.leiz.list;

/**
 * @author zhanglei
 * @date 2021/10/24 下午11:25
 */
public class SingLinkedList {
    //初始化一个头节点，不动，不放具体数据
    private HeroNode head = new HeroNode(0,"","");
    //添加节点到链表
    //当不考虑编号顺序时，直接找到最后的节点，使其next指向新的节点
    public void add(HeroNode heroNode){
        //头节点（head）不能动，所以需要辅助节点 temp
        HeroNode temp = head;
        //遍历链表，找到最后的节点
        while(true) {
            //找到链表的最后
            if(temp.next == null){
                break;
            }
            //如果没有找到，后移查找
            temp = temp.next;
        }
        //当退出循环时，temp就指向了链表的最后
        temp.next = heroNode;
    }
    //显示链表
    //head节点不能动，所以需要辅助变量
    public void list() {
        //判断链表是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (temp != null) {
            //判断是否到最后
            //输出节点的信息
            System.out.println(temp);
            //将next后移
            temp = temp.next;
        }
    }

//    //方式二添加
//    public void addByOrder(HeroNode heroNode) {
//        //head不能动，仍然通过辅助变量
//        //单链表，找到temp是位于添加位置的前一个节点，否则插入不了
//        HeroNode temp = head;
//        boolean flag = false;   //标识编号是否存在
//        while (true) {
//            if(temp.next == null) { //在链表最后
//                break;
//            }
//            if(temp.next.no > heroNode.no) { //位置找到，就在temp后面插入
//                break;
//            }else if(temp.next.no == heroNode.no) { //说明希望添加的heroNode的编号已经存在
//                flag = true;    //说明编号存在
//                break;
//            }
//            temp = temp.next;   //后移，遍历当前链表
//        }
//        //判断flag的值
//        if(flag) {  //不能添加，编号已经存在
//            System.out.printf("准备插入的英雄的编号 %d 已经存在了，不能加入\n", heroNode.no);
//        }else {
//            //插入到链表中，temp中
//            heroNode.next = temp.next;
//            temp.next = heroNode;
//        }
//    }


}
