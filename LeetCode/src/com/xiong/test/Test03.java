package com.sangfor.security.test;

/**
 * 二分法查找以及延伸
 * @version 2.0.0
 * @author 赵小雄59782
 * @date 2020/11/30 12:00
 */
public class Test03 {

    /*** 
     * 二分法查找有序数组
     *
     * @author 赵小雄59782
     * @date 2020/11/30 20:50
     * @param arr
     * @param num
     * @return 
     */
    public static int findNum(int[] arr, int num) {
        if (null == arr || arr.length == 0) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int medium = (start + end) / 2;
            if (num == arr[medium]) {
                return medium;
            }
            if(num > arr[medium]) {
                start = medium + 1;
            }
            if(num < arr[medium]) {
                end = medium - 1;
            }
        }
        return -1;
    }


    /*** 
     * 查询有序二维数组中是否存在某个数值
     *
     * @author 赵小雄59782
     * @date 2020/11/30 20:54
     * @param num todo {这里必须添加参数注释}
     * @return 
     */
    public static boolean findNum(int[][] num) {
        return false;
    }

    /*** 
     * 数组归类，左边奇数右边偶数
     *
     * @author 赵小雄59782
     * @date 2020/11/30 20:51
     * @param num
     * @return 
     */
    public static void groupNum(int[] num) {
        if (null == num || num.length == 1) {
            return;
        }
        int start = 0;
        int end = num.length - 1;
        while (start < end) {

            while (start < end && num[start] % 2 != 0) {
                start++;
            }
            while (start < end && num[end] % 2 == 0) {
                end--;
            }

            // swap
            int tmp = num[start];
            num[start] = num[end];
            num[end] = tmp;
        }
    }

    //打印数组
    public static void print(int[] num) {
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + "->");
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        //findNum(arr, 5);
        //groupNum(arr);
    }
}
