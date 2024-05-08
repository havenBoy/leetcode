package com.leetcode.leet_problems.Array;

import java.util.Arrays;

public class Test27_removeTarget {

    /*
    给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，
    返回移除后数组的新长度
    不需要考虑数组超出长度的数字
     */

    /**
     * 遍历一遍数组即可
     * 找出不等于目标值的数字，赋值到最前面
     * 使用一个下标值记录，如果赋值过则加1
     * @param arr 数组
     * @param target 目标值
     * @return 返回去重后数组的下标值，即小于等于该下标的数组值即为所需
     */
    public static int removeTarget(int[] arr, int target) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (target != arr[i]) {
                arr[index] = arr[i];
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 4};
        System.out.println(removeTarget(arr, 3));
        System.out.println(Arrays.toString(arr));
    }
}
