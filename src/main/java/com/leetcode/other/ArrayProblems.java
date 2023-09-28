package com.leetcode.other;

import java.util.Arrays;

public class ArrayProblems {

    /*
     * 题目描述：
     * 给你一个数组nums和一个整数 target
     * 找出其中2个元素的和为目标值，2个元素为数组不同元素
     * 所有符合这个条件的个数
     */

    /**
     * 暴力解决: 2个for循环
     *
     * @param arr    给定数组
     * @param target 目标值
     * @return 返回构造方式的个数
     */
    public static int findTargetSumWays(int[] arr, int target) {
        int count = 0;
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i1 = j + 1; i1 < arr.length; i1++) {
                if (arr[j] + arr[i1] == target) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 先进行一次快排，后使用2个指针移动取和
     *
     * @param arr    给定数组
     * @param target 目标值
     * @return 返回构造方式的个数
     */
    public static int findTargetSumWays_1(int[] arr, int target) {
        int count = 0;
        // 这里使用快排，需要手写
        Arrays.sort(arr);
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum < target) {
                start++;
            } else if (sum > target) {
                end--;
            } else {
                count++;
                start++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1, 10, 11, 13, 12};
        int target = 15;
        System.out.println(findTargetSumWays_1(arr, target));
    }
}
