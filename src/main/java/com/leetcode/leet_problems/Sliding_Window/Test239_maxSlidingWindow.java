package com.leetcode.leet_problems.Sliding_Window;

import java.util.*;

public class Test239_maxSlidingWindow {

    /*
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧
     * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
     *
     * 返回 滑动窗口中的最大值
     */

    /**
     * 滑动窗口和最大
     * @param arr 数组
     * @param k 滑动大小
     * @return 返回最大值
     */
    public static int maxSlidingWindowSum(int[] arr, int k) {
        int max = 0;
        for (int i = 0; i < arr.length - k + 1; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    /**
     * 暴力解法：
     * 滑动窗口和最大
     * @param arr 数组
     * @param k 滑动大小
     * @return 返回最大值
     */
    public static int[] maxSlidingWindow(int[] arr, int k) {
        int[] res = new int[arr.length - k + 1];
        for (int i = 0; i < arr.length - k + 1; i++) {
            int max = arr[i];
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, arr[j]);
            }
            res[i] = max;
        }
        return res;
    }

    /**
     * 暴力解法：
     * 滑动窗口和最大
     * @param arr 数组
     * @param k 滑动大小
     * @return 返回最大值
     */
    public static int[] maxSlidingWindowNew(int[] arr, int k) {
        int[] res = new int[arr.length - k + 1];

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            queue.add(arr[i]);
        }

        for (int i = k; i < arr.length ; i++) {
            int max = arr[i];
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, arr[j]);
            }
            res[i] = max;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(maxSlidingWindowSum(nums, 3));
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));


        int[] nums1 = {1,3,10,-3,5,3,6,7};
//        PriorityQueue<Integer> queue = new PriorityQueue<>(3, (Comparator.comparingInt(o -> o)));
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < 3; i++) {
            queue.add(nums1[i]);
        }
        System.out.println(queue.peek());
    }
}
