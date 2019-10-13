package com.cn.BinaryTree;

public class TreeNode {
    //节点的值
    int value;

    //左节点
    TreeNode leftNode;
    //右节点
    TreeNode rightNode;

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
}
