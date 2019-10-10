package com.cn.dataStruct;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 用Java实现插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{0,8,2,9,3,6,4,5,1};
        Insert(arr);
        System.out.println(Arrays.toString(arr));

    }


    /**
     * 插入排序算法
     * @param arr 需要被排序的数组
      */
    public static void Insert(int[] arr){

        //我们先来像一个问题，我们需要排序多少轮呢？，也就是从大的方向来说，自然是arr.length-1
        //我们取数字要取到最后一个，就是arr.length-1的下标
        for(int i = 1; i <= arr.length - 1; i++){

            //这个时候我们先取到第二个数字，实际上第一个数字和它本身对比，没啥意义的对吧
            for(int j = i;j>=0;j--){
                //我们拿到第二个数字之后，就开始和它前一个数字进行对比
                //如果它比它前一个数字要大或者相同，则不动，整个循环结束，然后
                if(arr[j]>=arr[j-1]){
                    break;
                }else{
                    //这个时候它比它的前一个数字要小，于是它要它的前一个数字替换位置
                    //我们先来找一个中间变量存贮它的数据
                    int temp = arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                    //替换完毕之后，我们开始下一个循环，j减去1，于是开始循环，直到遇到比他小的或者相同的数字，终止循环
                }
            }
        }

    }
}
