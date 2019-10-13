package com.cn.BinaryTree;

public class TreeNode {
    //节点的值
    int value;

    //左节点
    TreeNode leftNode;
    //右节点
    TreeNode rightNode;

    //给节点赋值
    public TreeNode(int value){
        this.value = value;
    }

    /**
     * 设置左节点
     * @param leftNode
     */
    public void setLeftNode(TreeNode leftNode){
        this.leftNode = leftNode;
    }

    /**
     * 设置右节点
     * @param rightNode
     */
    public void setRightNode(TreeNode rightNode){
        this.rightNode = rightNode;
    }

    /**
     * 前序遍历
     */
    public  void frontShow(){
        System.out.println(value);
        if(leftNode!=null){
            leftNode.frontShow();
        }
        if(rightNode!=null){
            rightNode.frontShow();
        }
    }

    /**
     * 中序遍历
     */
    public void midShow(){

        if(leftNode!=null){
            leftNode.midShow();
        }
        System.out.println(value);
        if(rightNode!=null){
            rightNode.midShow();
        }
    }

    /**
     * 后序遍历
     */
    public void afterShow(){

        if(leftNode!=null){
            leftNode.afterShow();
        }

        if(rightNode!=null){
            rightNode.afterShow();
        }
        System.out.println(value);
    }
}
