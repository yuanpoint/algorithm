package com.cn.dataStruct;

public class line {

    public static void main(String[] args) {

        binarySearch();
    }

    /**
     * 线性查找算法
     * @param target 想要查找的目标
     * @return
     */
    public static int lineSearch(int target){
        //预定义index
        int index = -1;
        //假设数据为arr
        int[] arr = new int[]{1,2,3,4,5};
        for (int i = 0;i < arr.length;i++){
            if(arr[i] == target){
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * 二分法查找算法
     */
    public static void binarySearch(){

        //设立要查找的目标，不考虑找不到的情况
        int target = 9;
        //假设查找的数组，必须顺序排列
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};

        //设立开始寻找的目标
        int start = 0;
        //设立结束的目标
        int end = 8;

        //设立当前的二分点
        int binaryPoint = (end+start)/2;

        //寻找到的index
        int index = -1;

        while (true){

            //先考虑二分点恰好就是当前需要寻找的目标的情况
            if(arr[binaryPoint] == target){
                index = binaryPoint;
                break;
            }else{
                //如果找到的二分点的数值比目标值大，说明目标在小的那个区域
                if(arr[binaryPoint] > target){
                    //结束的要小一个，因为要去掉正好等于的情况
                    binaryPoint = binaryPoint - 1;
                    binaryPoint = (binaryPoint + start) / 2;
                }else{
                    //开始的要大一个，要去掉正好等于的情况
                    binaryPoint = binaryPoint + 1;
                    //如果二分点的数值比目标要小，说明目标在大的区域
                    binaryPoint = (binaryPoint + end) / 2;
                }
            }
        }
        System.out.println(index);

    }
}
