package com.cn.dataStruct;

public class Test {
    public static void main(String[] args) {


        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.append(node2).append(node3).append(new Node(4));

        node1.show();

        node2.after(new Node(5));

        node1.show();

    }
}
