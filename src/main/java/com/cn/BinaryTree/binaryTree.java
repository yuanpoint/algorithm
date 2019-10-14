package com.cn.BinaryTree;

public class binaryTree {

    //设置根节点
    TreeNode root;

    //设置根节点
    public void setRoot(TreeNode root){

        this.root = root;
    }

    //获取根节点
    public TreeNode getRoot(TreeNode root){
        return this.root;
    }

    /**
     * 前序遍历
     */
    public void frontShow(){
        root.frontShow();
    }

    /**
     * 中序遍历
     */
    public void midShow(){
        root.midShow();
    }

    /**
     * 后序遍历
     */
    public void afterShow(){
        root.afterShow();
    }

    public TreeNode frontSearch(int i) {
        return root.frontSearch(i);
    }

    /**
     * 删除节点
     * @param i
     */
    public void delete(int i) {
        root.delete(i);
    }
}
