package com.cn.dataStruct;

/**
 * 用Java实现单链表
 */
public class Node {

    //节点内容
    int data;
    //下一个节点,这里为啥要定义成Node类型呢？这里是重点，next 存贮的是下一个节点的对象地址，找到了对象地址，则就找到了下一个data的数据
    Node next;

    //通过构造函数指定数据
    public Node(int data){
        this.data = data;
    }

    //为节点追加节点
    public Node append(Node node){
        //首先指定当前节点
        Node currentNode = this;
        //开始循环，找到最后一个有next的节点
        while (currentNode.getNext() != null){
            //如果有next节点说明不是链尾，则赋给当前节点
            currentNode = currentNode.getNext();
        }
        //然后找到最后一个节点之后，把数据给添加上去
        currentNode.next = node;

        //返回当前的对象实力，可以通过链式调用
        return this;
    }

    //获取当前的next,其实是当前节点存储的下一个节点的对象引用
    public Node getNext(){
        return this.next;
    }

    /**
     * 获取当前节点的数据
     * @return 当前节点的数据
     */
    public int getData(){
        return this.data;
    }

    /**
     * 当前的节点是否是最后一个节点
     * @return
     */
    public boolean isLast(){
        //如果当前的节点是最后一个节点，那他的next一定是空，这个在追加的时候使用同样的方法来判断的
       return this.next == null;
    }
}
