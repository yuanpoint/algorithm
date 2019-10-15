package com.cn.dataStruct;

import java.util.Arrays;

/**
 * 用Java实现堆排序
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{9,6,8,7,0,1,10,4,2};
        //开始位置
        int start = (arr.length-1)/2;
        for(int i = start;i>=0;i--){
             heap(arr,arr.length,i);
        }

        for(int i = arr.length-1;i>0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heap(arr,i,0);
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序
     * @param arr
     * @param size
     * @param index
     */
    public static void heap(int[] arr,int size,int index){
        //左子节点
        int leftNode = 2*index+1;
        //右子节点
        int rightNode = 2*index+2;

        //设置最大值
        int max = index;

        //进行和左子节点比较
        if(leftNode<size && arr[leftNode]>arr[max]){
            max = leftNode;
        }
        //和右子节点比较
        if(rightNode<size && arr[rightNode]>arr[max]){
            max = rightNode;
        }

        //找到最大的节点之后就替换
        if(max != index){
            int temp = arr[index];
            arr[index] = arr[max];
            arr[max] = temp;
            //然后如果还有的话就继续替换
            heap(arr,size,max);
        }

    }
}
