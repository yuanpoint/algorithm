package com.cn.dataStruct;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 用Java实现冒泡排序算法
 */
public class bubbSort {

    public static void main(String[] args) {
        //定义一个需要排序的数组
        int[] arr = new int[]{1,5,6,0,8,3,9,2,4,7};
        System.out.println(Arrays.toString(arr));
        //排序
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 需要被排序的数组
     * @param arr
     */
    public static void sort(int[] arr){

        //拿到这个问题，我们先思考一下一共比较数组的长度减去一次，因为第一个和第二个开始比较
        for(int i = 0; i < arr.length - 1; i++){
            //然后每一个数字需要比较次数为，8，7，7 ...
            for(int j = 0; j < arr.length - 1 - i; j++){
                //让当前的数字和它后面的数字进行比较，如果当前的数字比后面的数字大的话，则交换位置。
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
