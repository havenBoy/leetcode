package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分法查找以及延伸：双指针法
 * @version 2.0.0
 * @author zxx
 * @date 2020/11/30 12:00
 */
public class Test03 {

    /*** 
     * 二分法查找有序数组
     *
     * @author zxx
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
     * 剑指OFFER：
     * 查询有序二维数组中是否存在某个数值
     *
     * @author zxx
     * @date 2020/11/30 20:54
     * @param num 二维数组
     * @return 
     */
    public static boolean findNum(int[][] num) {
        return false;
    }

    /*** 
     * 剑指OFFER：21
     * 数组归类，左边奇数右边偶数
     *
     * @author zxx
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

    /**
     * LeetCode:
     * 27.移除目标元素
     * 将数组中非目标元素移动到数组的前方
     * 思路：双指针法
     * array  数组
     * target 目标数字
     * @return
     */

    public static int removeElement(int[] array, int target) {
        int start = 0;
        for (int end = 0; end < array.length; end++) {
            if (target != array[end]) {
                array[start] = array[end];
                start++;
            }
        }
        return start;
    }

    /**
     * LeetCode:
     * 26.移除重复元素
     * 将排序数组中重复的元素删除，使得元素只出现一次,返回数组最终长度
     * 思路：双指针法
     * array  数组
     * @return
     */

    public static int removeDuplicates(int[] array) {
        if (null == array || array.length <= 1) {
            return null == array ? 0 : array.length;
        }
        int start = 0;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (list.contains(array[i])) {
                continue;
            } else {
                array[start] = array[i];
                start++;
                list.add(array[i]);
            }
        }
        return start;
    }

    //打印工具类
    public static void print(int[] num) {
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + "->");
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,1,2};
        //findNum(arr, 5);
        //groupNum(arr);
        System.out.println(removeDuplicates(arr));
        print(arr);
    }
}
