package com.cn.BinaryTree;

public class testBinaryTree {

    /**
     * 测试二叉树
     * @param args
     */
    public static void main(String[] args) {

        //初始化二叉树对象
       binaryTree binTree = new binaryTree();

       //设置根节点
        TreeNode root = new TreeNode(1);
        binTree.setRoot(root);

        TreeNode leftNode = new TreeNode(2);
       //把新创建的节点设置为左节点
        root.setLeftNode(leftNode);
        //设置右节点
        TreeNode rightNode = new TreeNode(3);
        root.setRightNode(rightNode);

        //给左节点设置左右节点
        leftNode.setLeftNode(new TreeNode(4));
        leftNode.setRightNode(new TreeNode(5));

        //给右节点设置左右节点
        rightNode.setLeftNode(new TreeNode(6));
        rightNode.setRightNode(new TreeNode(7));


        //通过前序遍历遍历二叉树
        binTree.frontShow();
        System.out.println("=================");
        //中序遍历
        binTree.midShow();
        System.out.println("=================");
        //后序遍历
        binTree.afterShow();

        //通过前序查找，找相应的节点
        TreeNode nodes = binTree.frontSearch(5);
        System.out.println(nodes);

        //删除节点
        binTree.delete(7);

    }
}
