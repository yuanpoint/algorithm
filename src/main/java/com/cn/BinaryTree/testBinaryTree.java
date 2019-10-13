package com.cn.BinaryTree;

public class testBinaryTree {

    /**
     * 测试二叉树
     * @param args
     */
    public static void main(String[] args) {
       binaryTree binTree = new binaryTree();

        TreeNode root = new TreeNode(1);
        binTree.setRoot(root);

        TreeNode leftNode = new TreeNode(2);
       //把新创建的节点设置为左节点
        root.setLeftNode(leftNode);
        //设置右节点
        TreeNode rightNode = new TreeNode(3);
        root.setRightNode(rightNode);


    }
}
