package com.cn.dataStruct;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 用Java实现希尔排序
 */
public class shellSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,8,3,4,2,0,5,6,3,2,8,9};
        shell(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 希尔排序
     * @param arr 要排序的数组
     */
    public static void shell(int[] arr){

        //希尔排序实际上是直接插入排序的升级版本，在直接插入排序的算法中，如果越到后面突然出现某个比较小的值
        //这个时候排序的步骤就越长，希尔排序就是为了解决这个问题，先大致的排一下，然后拍的过程中用的是直接插入排序算法

        //首先计算步长
        for(int d = arr.length/2;d>0;d = d/2){
            //开始直接排序算法
            //先来一轮直接排序
            for(int i = d;i < arr.length;i++){
                //然后开始交换
                for(int j = i - d;j >=0; j = j-d){
                    if(arr[j] > arr[j+d]){
                        int temp = arr[j];
                        arr[j] = arr[j+d];
                        arr[j+d] = temp;
                    }
                }
            }
        }
    }
}
