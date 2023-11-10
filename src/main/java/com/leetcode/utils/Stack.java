package com.leetcode.utils;

import java.util.Arrays;

public class Stack {

    /*
     * 单调栈的说明
     */

    /**
     * 单调栈的构建
     * 1. 数据会被一一压栈
     * 2. 如果碰到比栈顶的数据大或者小的时候，将栈顶出栈，直到数据比较不大于或者小于数
     * 3. 将需要入栈的数据压栈，依次类推
     * @param arr 输入数组
     */
    public static java.util.Stack<Integer> stackFun(int[] arr) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (int j : arr) {
            if (stack.isEmpty() || stack.peek() <= j) {
                stack.push(j);
            } else {
                while (!stack.isEmpty() && stack.peek() > j) {
                    stack.pop();
                }
                stack.push(j);
            }
        }
        return stack;
    }

    /**
     * 气温的度数为数组展示
     * 要想观测到更高的气温，至少需要等待的天数。
     * 如果气温在这之后都不会升高，请在该位置用 0 来代替
     * @param nums 气温数组
     * @return 返回结果数组
     */
    public static int[] dailyTemperatures(int[] nums) {
        int[] newNums = new int[nums.length];
        int index = 0;
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            while (!stack.isEmpty() && stack.peek() > nums[i]) {
                stack.pop();
                count++;
            }
            stack.push(nums[i]);

        }
        return newNums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3};
        System.out.println(stackFun(nums));
        System.out.println(Arrays.toString(dailyTemperatures(nums)));
    }
}
