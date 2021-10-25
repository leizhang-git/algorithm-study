package com.leiz.list;

/**
 * @author zhanglei
 * @date 2021/10/24 下午11:26
 */
public class SingLinkedListTest {
    public static void main(String[] args) {
        //进行一个测试
        //先创建节点
        HeroNode node1 = new HeroNode(1, "jishuo", "sb");
        HeroNode node2 = new HeroNode(2, "zhanglei", "nb");
        HeroNode node3 = new HeroNode(3, "yuanguowei", "qb");
        HeroNode node4 = new HeroNode(4, "suzhihui", "bb");
        HeroNode node5 = new HeroNode(5, "wangyanming", "mb");
        HeroNode node6 = new HeroNode(6, "wangbin", "zb");
        //创建链表，加入(无序)
        SingLinkedList singLinkedList = new SingLinkedList();
        singLinkedList.add(node1);
        singLinkedList.add(node4);
        singLinkedList.add(node3);
        singLinkedList.add(node2);
        singLinkedList.add(node5);
        singLinkedList.add(node6);
        //显示
        singLinkedList.list();
    }
}
