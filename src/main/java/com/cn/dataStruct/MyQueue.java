package com.cn.dataStruct;

/**
 * 用Java实现一个队列
 */
public class MyQueue {

    int[] elements;

    public MyQueue(){
        elements = new int[0];
    }
    //向队列中推入元素
    public void push(int element){
        //先初始化一个新的数组，因为要向队列中推入元素，所以需要个数比之前的数组个数要多一个，所以这里加1
        int[] newArr = new int[elements.length + 1];
        //然后把原先数组中的元素挪到新的数组中
        for(int i = 0; i < elements.length; i++){
            newArr[i] = elements[i];
        }
        //把新加入的元素放到新的数组的最后面
        newArr[elements.length] = element;
        //然后将原来的数组替换成新的数组
        elements = newArr;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        if(elements.length == 0){
            return true;
        }else{
            return false;
        }
    }
    //出队
    public int pull(){
        //判断队列是否为空
        if(isEmpty()){
            //如果为空，则抛出异常
            System.out.println("对列中元素为空");
            throw new NullPointerException();
        }
        //先初始化一个新的数组用来盛放新的队列,因为要取出数据，所以队列的大小是原先队列大小减1
        int[] newArr = new int[elements.length - 1];
        //将数据放入新的数组中
        for(int i = 1; i < elements.length;i++){
            newArr[i-1] = elements[i];
        }
        //将第一个元素取出来
        int element = elements[0];
        //将数组改成新的数组
        elements = newArr;
        return element;
    }

    /**
     * 查看队列中的元素
     */
    public void getQueue(){
        //判断队列是否为空
        if(isEmpty()){
            //如果为空，则抛出异常
            System.out.println("对列中元素为空");
            throw new NullPointerException();
        }
        for(int element:elements){
            System.out.println(element);
        }
    }
}
