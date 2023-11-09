package com.leetcode.utils;

import java.util.LinkedList;
import java.util.List;

public class Stack {

    /*
     * 单调栈的说明
     */

    /**
     * 单调栈的构建
     * @param arr 输入数组
     */
    public static void stackFun(int[] arr) {

        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (int j : arr) {
            if (stack.isEmpty() || stack.pop() >= j) {
                stack.push(j);
            } else {
                List<Integer> list = new LinkedList<>();
                while (!stack.isEmpty() && stack.peek() < j) {
                    list.add(stack.pop());
                }
                stack.push(j);
                for (int i1 = list.size() - 1; i1 >= 0; i1--) {
                    stack.push(list.get(i1));
                }
            }
        }
    }
}
