package com.cn.dataStruct;

public class Test {
    public static void main(String[] args) {


        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.append(node2).append(node3);

        System.out.println(node1.next);
        System.out.println(node2);
        System.out.println(node2.next);
        System.out.println(node3);


    }
}
