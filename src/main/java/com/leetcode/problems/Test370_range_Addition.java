package com.leetcode.problems;

public class Test370_range_Addition {

    /*
     * 题目描述：
     * 假设你有一个长度为 n 的数组，初始情况下所有的数字均为 0，你将会被给出 k个更新的操作。
     * 其中，每个操作会被表示为一个三元组：[startIndex, endIndex, inc]，
     * 你需要将子数组 A[startIndex ... endIndex]（包括 startIndex 和 endIndex）增加 inc。
     * 请你返回 k 次操作后的数组
     * length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
     * return [-2,0,3,5,3]
     */

    /**
     * 暴力解决
     * @param length 数组长度
     * @param arr 操作数组
     * @return 返回结果数组
     */
    public static int[] range_Addition(int length, int[][] arr) {
        int[] res = new int[length];
        for (int[] ints : arr) {
            int start = ints[0];
            int end = ints[1];
            int incr = ints[2];
            for (int j = start; j <= end && j < length; j++) {
                res[j] = res[j] + incr;
            }
        }
        return res;
    }

    /**
     * TODO 新的思路
     * @param length 数组长度
     * @param arr 操作数组
     * @return 返回结果数组
     */
    public static int[] range_AdditionNew(int length, int[][] arr) {
        int[] res = new int[length];
        return res;
    }

    public static void main(String[] args) {
        int[][] updates = {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
        int length = 5;
        int[] arr = range_Addition(length, updates);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
