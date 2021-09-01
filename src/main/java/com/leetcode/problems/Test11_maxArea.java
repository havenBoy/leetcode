package com.leetcode.problems;

public class Test11_maxArea {

    /*
      给到一个数组，返回所能围成的最大矩形的面积

     */

    /**
     * 最大区域面积  二分策略调整
     * 思路：首先尝试获取到最大的长，可以获取到当前长度下的面积
     * 要获取到更大的面积，需要试着调整长，调整长的策略：
     * 保留当前最大的高，移动较小值的下标重新计算面积大小。
     *
     * @param height 输入的数组
     * @return 返回最大面积数字
     */
    public static int maxArea(int[] height) {
        int length = height.length;
        int start = 0, end = length - 1;
        int result = 0;
        while (start < end) {
            int startNum = height[start];
            int endNum = height[end];
            result = Math.max(result, (end - start) * Math.min(startNum, endNum));
            if (startNum >= endNum) {
                end--;
            } else {
                start++;
            }
        }
        return result;
    }
}
