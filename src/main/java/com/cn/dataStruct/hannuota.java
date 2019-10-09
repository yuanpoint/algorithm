package com.cn.dataStruct;

/**
 * 用Java实现汉诺塔问题
 */
public class hannuota {
    public static void main(String[] args) {
        move(2,"A","B","c");
    }
    /**
     * 移动盘子
     * @param n 代表有多少个盘子
     * @param from 移动哪个盘子上面的内容 开始的柱子
     * @param to 移动的盘子到哪个上面柱子上去 目标柱子
     * @param in  中间的盘子 中间的柱子
     */
    public static void move(int n,String from,String in,String to){
        //当只有一个盘子的时候，我们直接把盘子从A柱子移动到C盘子上面去
        if(n == 1){
            System.out.println("第1个盘子从" + from + "移动到" + to);
        }else{
            //当有两个盘子的时候,这里相当于把第一个移动到B柱子上
            move(n-1,from,to,in);
            System.out.println("将"+ n + "个盘子从" + from + "移动到" + in);
            //然后把第二个盘子移动，相当于把中间移动到C上面去
            move(n-1,in,from,to);

        }
    }

}
