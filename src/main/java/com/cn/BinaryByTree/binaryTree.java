package com.cn.BinaryByTree;

/**
 * 用Java实现顺序存贮的二叉树
 */
public class binaryTree {
   //所谓顺序存贮的二叉树，我们可以理解为用一个数组来存贮二叉数的节点
    //当然了，有公式可以计算叶子节点
    //比如左叶子节点为2*n+1
    //右叶子节点为2*n+2

    int[] data;
    //初始化数组
    public binaryTree(int[] data){
        this.data = data;
    }
    //构建重载方法
    public void frontShow(){
        frontShow(0);
    }

    //遍历数组，采用前序遍历的方法
    public void frontShow(int index){
        //查看当前节点是否存在，如果不存在，直接返回
        if(data==null || data.length==0){
            return;
        }
        //输出当前节点
        System.out.println(data[index]);
        //先遍历左节点
        if(2*index+1<data.length){
            frontShow(2*index+1);
        }
        //遍历右节点
        if(2*index+1<data.length){
            frontShow(2*index+2);
        }
    }

}
