package com.cn.dataStruct;

/**
 * 用Java实现一个栈
 */
public class MyStack {
    //定义一个数组
    int[] elements;

    //初始化数组,通过构造方法
    public MyStack(){
        elements = new int[0];
    }
    //判断栈中元素是否为空
    public Boolean isEmpty(){
        if(elements.length == 0){
            return true;
        }else{
            return false;
        }
    }
    //获取栈中的元素
    public void getStact(){
        //先来判断栈中是否还具有元素，如果没有元素了，则提示元素为空
        if(isEmpty()){
            System.out.println("栈中元素为空");
            throw new NullPointerException();
        }
        for (int element:elements) {
            System.out.println(element);
        }
    }
    //向栈中推入元素
    public void push(int element){
        //先初始化一个新的数组，因为要向栈中推入元素，所以需要个数比之前的数组个数要多一个，所以这里加1
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
    //取出栈定元素
    public int fetch(){
        //先来判断栈中是否还具有元素，如果没有元素了，则提示元素为空
        if(isEmpty()){
            System.out.println("栈中元素为空");
            throw new NullPointerException();
        }
        //先初始化一个新的数组，因为要把栈中最后一个元素取出来，所以要把这个元素给删除掉,所以减去一
        int[] newArr = new int[elements.length - 1];
        //将原有数组中的元素从开始到倒数第二位元素放入到新的数组中，因为倒数第一位元素是我们要取出来的数据
        for (int i = 0; i < elements.length - 1;i++){
            newArr[i] = elements[i];
        }
        //取出最后一位数据
        int lastNum = elements[elements.length-1];
        //将数组复制给新的数组
        elements = newArr;
        //然后返回最后一位数据
        return lastNum;
    }
    //查看栈顶元素
    public int topElement(){
        //先来判断栈中是否还具有元素，如果没有元素了，则提示元素为空
        if(isEmpty()){
            System.out.println("栈中元素为空");
            throw new NullPointerException();
        }
        return elements[elements.length - 1];
    }

}
