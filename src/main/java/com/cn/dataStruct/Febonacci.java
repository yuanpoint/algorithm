package com.cn.dataStruct;

/**
 * 用Java实现斐波那契数列
 */
public class Febonacci {
    /**
     * 用递归实现斐波那契数列
     * @param i 需要得到的第i项
     * @return 第i项内容
     */
    public static int febonaccis(int i){
        if(i == 1 || i == 2){
            return 1;
        }else{
            return febonaccis(i-1) + febonaccis(i - 2);
        }
    }

    public static void main(String[] args) {
       System.out.println( febonaccis(6) );
    }

}
