package com.cn.dataStruct;

import java.awt.image.DataBufferDouble;

/**
 * 用Java实现双向循环链表
 */
public class DoubleNode {

    //先定义上一个节点的位置信息 ,在单一节点的时候，它的上一个节点其实就是它本身自己，所以这里用this
    DoubleNode pre = this;
    //定义下一个节点的位置信息 ，在单一节点的时候，它的下一个节点其实就是它本身自己，所以这里用this
    DoubleNode next = this;

    //定义数据
    int data;

    /**
     * 用构造方法初始化当前节点的的数据
     * @param data 当前节点的数据
     */
    public DoubleNode(int data){
        this.data = data;
    }

    /**
     * 给当前节点增加节点
     * @param node 需要被增加的节点
     * @return
     */
    public DoubleNode after(DoubleNode node){
        //this.next是当前节点记录的下一个节点的位置
        DoubleNode nextNode = this.next;

        //先给当前节点记录被增加节点的位置信息，
        this.next = node;
        //然后记录被增加节点的前一个节点
        node.pre = this.next;
        //然后记录被增加节点的下一个节点
        node.next = nextNode;
        //然后修改原本第二个节点的前一个节点的位置信息
        node.next.pre = node;

        return this;
    }

    /**
     * 获取当前节点的next记录位置信息
     * @return
     */
    public DoubleNode next(){
       return this.next;
    }

    /**
     * 获取当前节点的前一个节点的位置信息
     * @return
     */
    public DoubleNode pre(){
        return this.pre;
    }

    /**
     * 获取当前的数据
     * @return
     */
    public int getData(){
        return this.data;
    }
}
