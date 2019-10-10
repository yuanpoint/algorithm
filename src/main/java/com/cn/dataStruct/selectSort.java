package com.cn.dataStruct;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * java实现选择排序
 */
public class selectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,7,3,4,2,6,8,9,3,0};
        select(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序
     * @param arr 需要排序的数组
     */
    public static void select(int[] arr){
        //先来说一下选择排序的思路吧
        //首先从第一个开始，先选择一个比较者，第一次是第一个，然后从第二个开始向后找，
        //找到一个比第一个还要小的数据，然后进行交换
        //之后第一个就不动了，然后从找比第二个小的数据，然后进行交换，依次进行
        for(int i = 0;i<arr.length;i++){
            int minIndex = i;
            for(int j = i+1;j<arr.length;j++){

                if(arr[minIndex]>arr[j]){
                    minIndex = j;
                }
            }
            if( i != minIndex ){
                int temp  = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
