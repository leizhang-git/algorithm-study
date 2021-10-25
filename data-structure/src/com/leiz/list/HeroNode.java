package com.leiz.list;

/**
 * 节点
 * @author zhanglei
 * @date 2021/10/24 下午11:25
 */
public class HeroNode {
    private int no;
    private String name;
    private String nickname;    //昵称
    public HeroNode next;      //指向下一个节点
    //构造器
    public HeroNode(int hNo, String hName, String hNickname) {
        this.no = hNo;
        this.name = hName;
        this.nickname = hNickname;
    }
    //显示方便，重写toString
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
