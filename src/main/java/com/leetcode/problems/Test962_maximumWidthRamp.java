package com.leetcode.problems;

public class Test962_maximumWidthRamp {

    /**
     * 暴力解决
     * 最大的坡宽度
     * 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
     * 找出 A 中的坡的最大宽度，如果不存在，返回 0
     * [6,0,8,2,1,5]  return 4
     */
    public static int getMaximum_Width_Ramp(int[] arr) {
        int length = 0;
        if (arr.length <= 1) {
            return length;
        }
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            for (int i1 = i + 1; i1 < arr.length; i1++) {
                int num1 = arr[i1];
                if (num > num1) {
                    continue;
                }
                length = Math.max(i1 - i, length);
            }
        }
        return length;
    }

    public static void main(String[] args) {
//        int[] arr = new int[] {6,0,8,2,1,5};
        int[] arr = new int[] {9,8,1,0,1,9,4,0,4,1};
        System.out.println(getMaximum_Width_Ramp(arr));
    }
}
