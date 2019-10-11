package com.cn.dataStruct;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 用Java实现归并排序
 */
public class mergeSort {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,4,3};
        mergeArr(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 递归方式解决无序问题
     * @param arr 需要排序的数组
     * @param low 数组开始
     * @param high 数组结束
     */
    public static void mergeArr(int[] arr,int low,int high){
        //我们可以看书merge函数是假定两个数组都是在有序的情况下进行的排序
        //那么如果两个数组无序咋办，我们就要让他们有序，所以，我们可以把他无限拆分，直到拆成两个，然后让他们
        //取递归不就行了
        //设定一个边界
            int middle =  (low+high)/2;
            if(low<high){

                //所以先来出来左边
                mergeArr(arr,low,middle);
                //然后处理右边的
                mergeArr(arr,middle+1,high);
                //然后把这个数组进行归并
                merge(arr,low,middle,high);
            }

    }

    /**
     * 归并排序
     * @param arr 要排序的数组
     * @param low  开始位置
     * @param middle 中间位置
     * @param high 末尾位置
     */
    public static void merge(int[] arr, int low , int middle, int high){
       // System.out.println(Arrays.toString(arr));
        //System.out.println("low :" + low + " high: " + high);
        //设想这样一种情况，有两个数组，他们都是有序的，但是放到一起就是无序了
        //例如
        //int[] a = new int[]{4,5,6,7};
        //int[] b = new int[]{1,2,3,4,5};
        //上面这两个数组都是有序的，所以我们就假定传入进来的数据为下面这样子
        //int[] arr = new int[]{1,2,3,4,5,4,5,6,7}
        //我们要对一个数组排序，实际上我们是对一个数组排序

        //中间位置实际上就是第一个数组的默认，我们就这么认为

        //我们制定一个新的数组来装入排序好的数据
        int[] newArr = new int[high-low+1];

        //搞两个位置，记录下标移动
        int leftIndex = low;
        int rightIndex = middle + 1;

        //然后再初始化一个新的数组的下标，在移动的过程中，我们一个一个的增加
        int index = 0; //初始下标肯定是0嘛

        //我们来循环从每个数组中拿数据
        while (leftIndex<=middle && rightIndex <= high){
            //先从左边开始拿
            if(arr[leftIndex] <= arr[rightIndex]){
                //如果左边拿出一个，然后右边拿出一个，一对比，发现右边的比左边的大，这个时候，我们就认为左边的是最小的\
                //所以我们把比较小的放入到新数组中
                newArr[index] = arr[leftIndex];
                //放入进去之后，我们下次要再往新数组中放的话，这个时候index就要向前进一格，所以加 1
                index++;
                //然后我们左边的第一个已经拿了，之后，我们开始对比第二个，那么左边的下标就要也向前进一格
                leftIndex++;
            }else{
                //把右边的数据放入到新数组中
                newArr[index] = arr[rightIndex];
                //然后相应的新数组的下标也要增加
                index++;
                //然后右边的下标也要增加
                rightIndex++;
            }
        }
        //System.out.println(Arrays.toString(newArr));
        //OK，到了这一步，我们思考一个问题，就是有没有两个数组是一样长呢？
        //答案是无论是否等长，我们都要考虑不等长的情况下。

        while (rightIndex<=high){
            newArr[index] = arr[rightIndex];
            rightIndex++;
            index++;
        }
        while (leftIndex<=middle){
            newArr[index] = arr[leftIndex];
            leftIndex++;
            index++;
        }

        for(int k = 0;k<newArr.length;k++){
            //这一步要特别注意，是arr的k+low项，因为要拆分，所以新生成的数组不一定等长于原数组
            arr[k+low]=newArr[k];
        }

    }
}
