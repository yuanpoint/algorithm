package com.cn.Rare;

/**
 * 创建节点
 */
public class Node implements Comparable<Node> {

    //节点的权重
    int weights;

    //节点的值
    Byte data;

    //左节点
    Node leftNode;
    //右节点
    Node rightNode;

    //初始化节点
    public Node(Byte data, int weights){
        //给当前节点赋值
        this.data = data;
        //给当前权重赋予值
        this.weights = weights;
    }

    @Override
    public int compareTo(Node o) {
        return o.weights - this.weights;
    }

    @Override
    public String toString() {
        return "weights: " + this.weights + "data: " + this.data;
    }
}
