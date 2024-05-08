package com.leetcode.leet_problems.String;

public class Test07_reverseNum {

    /*
     * 题目描述
     *
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     *
     * 如果反转后整数超过 32 位的有符号整数的范围[−2^31,2^31− 1] ，就返回 0。
     *
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     *
     * 示例 1：
     *
     * 输入：x = 123
     * 输出：321
     * 示例 2：
     *
     * 输入：x = -123
     * 输出：-321
     * 示例 3：
     *
     * 输入：x = 120
     * 输出：21
     * 示例 4：
     *
     * 输入：x = 0
     * 输出：0
     */

    /**
     * 整数的反转
     *
     * @param x 待处理参数
     * @return 返回值
     */
    public static int reverse(int x) {
        long result = 0;
        long num = x;
        if (num < 0) num = -num;
        if (num > Integer.MAX_VALUE) return 0;
        while (num >= 1) {
            result = num % 10 + result * 10;
            num /= 10;
        }
        result = result > Integer.MAX_VALUE ? 0 : result;
        result = x < 0 ? -result : result;
        return (int) result;
    }
}
