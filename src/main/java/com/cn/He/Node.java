package com.cn.He;


public class Node implements Comparable<Node>{
    int value;

    public Node(int value){
        this.value =  value;
    }


    @Override
    public String toString() {
        return super.toString();
    }
    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
