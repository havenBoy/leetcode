package com.leetcode.leet_problems.Stack_Queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Test496_nextGreaterElement {

    /*
     * 题目描述：
     * 输入一个数组 nums，请你返回一个等长的结果数组，
     * 结果数组中对应索引存储着下一个更大元素，如果没有更大的元素，就存-1
     */


    /**
     * 暴力解决: 2个for循环
     *
     * @param arr 给定数组
     * @return 返回结果数组
     */
    public static int[] nextGreaterElement(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (res[i] < arr[j]) {
                    res[i] = arr[j];
                    break;
                }
                if (j == arr.length - 1) {
                    if (res[i] == arr[i]) {
                        res[i] = -1;
                    }
                }
            }
        }
        res[arr.length - 1] = -1;
        return res;
    }

    /**
     *
     * @param heights    给定数组
     * @return 返回构造方式的个数
     */
    public static int[] findTargetSumWaysNew(int[] heights) {
        int[] res = new int[heights.length];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && heights[deque.peek()] <= heights[i]) {
                deque.poll();
            }
            if (!deque.isEmpty()) {
                res[i] = deque.peek() - i;
            } else {
                res[i] = -1;
            }
            deque.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 2, 4, 3};
        System.out.println(Arrays.toString(findTargetSumWaysNew(arr)));
    }
}
