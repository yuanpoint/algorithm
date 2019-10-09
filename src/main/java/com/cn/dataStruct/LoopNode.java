package com.cn.dataStruct;

/**
 * 用Java实现循环链表
 */
public class LoopNode {

    //节点内容
    int data;
    //下一个节点,这里为啥要定义成Node类型呢？这里是重点，next 存贮的是下一个节点的对象地址，找到了对象地址，则就找到了下一个data的数据
    LoopNode next = this;

    /**
     * 通过构造函数指定数据
     * @param data
     */
    public LoopNode(int data){
        this.data = data;
    }

    /**
     * 展示所有节点的数据
     */
    public void show(){
        //定义当前节点
        LoopNode currentNode = this;
        //先输出当前节点信息
        System.out.print(currentNode.data + "\t");
        //循环判断当前节点是否还有下一个节点，如果没有则终止循环
        while (currentNode.getNext() != null){
            //因为上面首先输出了当前节点，所以这里将下一个节点赋给当前节点
            currentNode = currentNode.getNext();
            //然后输出下一个节点的信息
            System.out.print(currentNode.data + "\t");
        }
        //为什么要在当前节点输出下一个节点的信息呢？因为循环判断的条件是当前节点的下一个节点是否还存在，如果不提前输出下一个节点的，
        //那么最后一个节点实际上是没有下一个节点的，就不会被输出，实际上少了最后一个节点的信息
    }

    /**
     * 删除节点
     * @param node 被删除节点的前一个节点
     */
    public LoopNode poll(LoopNode node){
        //我们知道要想删除一个节点，就要找到被删除节点的后一个节点，然后把它连接到他的前一个节点上
        //但是我们没有办法知道它的前一个节点，所以，我们先知道前一个节点，然后这样我们可以找到要被
        //删除的节点和它的下一个节点，然后把他的下一个节点链接到它的上一个节点
        //这里node.next就是被删除的节点位置，我们要想删除它就要把它的下一个节点找到，然后复制给他
        //这里node.next.next就是被删除节点的下一个节点
       node.next = node.next.next;
       //这里也可以这样写
        // node.next = node.getNext().getNext();
       return this;
    }

    /**
     * 插入一个节点，这个节点可以是中间节点，也可以是末尾节点
     * @param node 将要被插入的节点
     * @return
     */
    public LoopNode after(LoopNode node){
        //先取出当前节点的下一个原本的节点位置信息
        LoopNode nextNode = this.next;

        //然后把当前节点的下一个节点重新规划为要插入的节点
        this.next = node;

        //然后把刚才取出的节点当成下下个节点，即为当前插入的节点的下一个节点
        node.next = nextNode;

        return this;
    }
    /**
     * 获取当前的next,其实是当前节点存储的下一个节点的对象引用
     * @return
     */
    public LoopNode getNext(){
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
