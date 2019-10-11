package com.cn.dataStruct;

public class Test {
    public static void main(String[] args) {


        counts(900,3);
    }

    /**
     * 指定输出具体的位数
     * @param num 需要取的数字
     * @param location 想要取第几位，从后向前依次是1，2
     */
    public static void counts(int num,int location){
        int x = 1;
        for(int i = 1; i <= location;i++){
            x = x*10;
        }
        int Y = num % x / (x/10);
        System.out.println(Y);
    }
}
