package com.leetcode.leet_problems;

import java.util.Arrays;

public class Test905_sortArrayByParity {

    /*
     * 题目描述：
     * 给你一个整数数组 nums,
     * 将nums中的的所有偶数元素移动到数组的前面，后跟所有奇数元素
     */

    /**
     * 双指针法
     * @param arr 给定数组
     * @return 返回数组
     */
    public static int[] sortArrayByParity(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int max = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            while (arr[max] % 2 != 0 && max > i) {
                max--;
            }
            if (max < i) {
                break;
            }
            if (arr[i] % 2 != 0) {
                int tmp = arr[i];
                arr[i] = arr[max];
                arr[max] = tmp;
                max--;
            }
        }
        return arr;
    }

    /**
     * 偶数在前，奇数在后
     * 申请一个等长的数组，遍历一次数组，
     * 将偶数放在第一个位置，奇数放在最后一个位置，分别记录下标
     * @param nums 输入数组
     * @return 返回结果数组
     */
    public static int[] sortArrayByParity2(int[] nums) {
        int[] newNums = new int[nums.length];
        int first = 0, last = nums.length - 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                newNums[first] = num;
                first++;
            } else {
                newNums[last] = num;
                last--;
            }
        }
        return newNums;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 5};
//        System.out.println(Arrays.toString(sortArrayByParity(arr)));
        System.out.println(Arrays.toString(sortArrayByParity2(arr)));
    }
}
