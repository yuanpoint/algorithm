package com.cn.dataStruct;

/**
 * Java时间复杂度例子
 *
 */
public class times {

    public static void main(String[] args) {

        //本例子中的两个例子用不同的方法来解决从1加到100的问题
        exampleOne();
        exampleTwo();
    }

    /**
     * 时间复杂度例子1
     */
    public static void exampleOne(){
        //这是第一个例子，用for 循环来从1开始加到100
        int sum = 0;
        for(int i = 1;i<=100;i++){
            sum += i;
        }
        System.out.println(sum);
    }

    /**
     * 时间复杂度第二个例子
     */
    public static void exampleTwo(){
        int x = (1 + 100) * (100/2);
        System.out.println(x);
    }
}
