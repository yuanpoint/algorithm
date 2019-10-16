package com.cn.He;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 用Java创建赫夫曼树
 */
public class HuffmanTree {

    public static void main(String[] args) {
        int[] arr = new int[]{3,7,8,29,5,11,23,14};
        Node node = createHuffmanTree(arr);
        System.out.println(node.value);
    }

    /**
     * 创建赫夫曼树
     * @param arr 树的节点
     */
    public static Node createHuffmanTree(int[] arr){
        //先使用数组中所有的元素创建若干个二叉树，只有几个节点的二叉树
        List<Node> nodes = new ArrayList<Node>();

        //循环创建二叉树
        for(int value:arr){
            nodes.add(new Node(value));
        }
        //循环处理
        while (nodes.size()>1){
            //排序
            Collections.sort(nodes);

            //取出最小的二叉树
            Node left = nodes.get(nodes.size()-1);
            //取出次小的二叉树
            Node right = nodes.get(nodes.size()-2);
            //创建一个新的二叉树
            Node parent = new Node(left.value+right.value);

            //把取出来的移除掉
            nodes.remove(left);
            nodes.remove(right);
            //放入原来的二叉树集合
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}
