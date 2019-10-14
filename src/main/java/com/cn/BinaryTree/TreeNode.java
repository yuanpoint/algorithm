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
     * 删除节点
     * @param i
     */
    public  void delete(int i) {
        //先指定夫节点
        TreeNode parent = this;
        //如果左节点正好是被删除的节点，直接就让他为null
        if(parent.leftNode!=null&&parent.leftNode.value == i){
            parent.leftNode = null;
            return;
        }
        //如果右节点正好是被删除的节点，直接让他为null
        if(parent.rightNode!=null&&parent.rightNode.value == i){
            parent.rightNode = null;
            return;
        }
        //如果左右节点都不是，那么则递归调用
        //先调用做节点
        parent=leftNode;
        if(parent!=null){
            parent.delete(i);
        }
        //然后掉用右节点
        parent = rightNode;
        if(parent!=null){
            parent.delete(i);
        }
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

    /**
     * 通过前序查找算法找到对应的节点
     * @param i
     */
    public TreeNode frontSearch(int i) {
        //先定义下返回值
        TreeNode target = null;
        //首先判断一下当前节点是否是需要被查找的节点
        if(this.value == i){
            return this;
        }else{
            //如果当前的节点不是,那就从叶子节点开始查找

            //先遍历左叶子节点
            if(leftNode != null){
                target = leftNode.frontSearch(i);
            }
            if(target!=null){
                return target;
            }
            if(rightNode != null){
                target = rightNode.frontSearch(i);
            }
        }
        return target;
    }
}
