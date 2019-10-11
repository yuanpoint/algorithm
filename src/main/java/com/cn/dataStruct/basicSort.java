package com.cn.dataStruct;


import java.util.Arrays;

/**
 * 用Java实现基数排序
 */
public class basicSort {
    public static void main(String[] args) {
        int[] arr = new int[]{100,200,345,2,45,900,12,6,3,126};
        basic(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 基数排序
     * @param arr 需要排序的数组
     */
    public static void basic(int[] arr){
        /**
         * 先来说一下基数排序的规则
         * 第一步，我们现在找到10个盒子，编号为0，1，2 。。。9
         * 然后把所有的数字先按照个位数字和编号相同的放入到相应的盒子中
         * 第三步，然后再把之前放入盒子中的数字按照放入的顺序取出来，然后再放会到原先的盒子中
         * 后面的步骤就是重复上面，但是需要注意的是上面比较好格数之后，接下来比较十位，然后是百位
         * 一直到最大数的位置
         */

        //按照上面的步骤，我们先找到需要比较多少次，也就是最大数是多少
        int maxNum = arr[0];
        //我们把第一个默认为最大数，依次从数组中找到比他大的，然后替换这个数字
        for(int i = 1; i < arr.length;i++){
            if(arr[i] > maxNum){
                maxNum = arr[i];
            }
        }

        //上面我们找到最大数之后，我们就知道比较多少次了，只需要计算这个最大数的长度
        //为了计算他的长度，我们可以把它变成一个字符串，这样子，我们可以直接计算他的长度
        int maxLength = (maxNum + "").length();

        for(int i = 1;i <= maxLength ; i++){

            //构建一个二位数组来装入每次
            int[][] temp = new int[10][arr.length];

            //构建一个数组用来记录每次数组中的键值存放位置
            int[][] index = new int[10][1];

            //这个时候我们来想这么一个问题，怎么求一个数字的个位数字是多少呢？
            //我们用这个数字除以10，然后余下是不是就是个位数数字，是的
            //所以我们总结出这样的一个规律
            //比如一个数字为 125
            //求个位 ： 125 % 10 / 1 = 5
            //求十位 ： 125 % 100 / 10 = 2
            //求百位 ： 125 % 1000 / 100 = 1
            //为了验证这个，我特地在本类下面有写这个函数counts,可以自行验证
            int z = 1;
            for(int p = 1;p <= i;p++){
                z = z * 10;
            }

            for(int j = 0;j < arr.length;j++){
                int Y = arr[j] % z / (z / 10);
                temp[Y][index[Y][0]] = arr[j];
                index[Y][0]++;

            }

            //经过第一轮个位之后，把数据重新放回到原先的数组中
            int p = 0;
            for(int k=0;k < 10;k++){
                for(int s = 0; s < index[k][0];s++){
                    arr[p] = temp[k][s];
                    p++;
                }
            }

        }


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
