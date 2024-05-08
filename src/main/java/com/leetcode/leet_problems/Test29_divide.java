package com.leetcode.leet_problems;

public class Test29_divide {

    /*
     * 题目描述：
     * 不使用除法，实现除法
     */

    /**
     * 遍历一遍数组即可
     * @param dividend 被除数
     * @param divisor 除数
     * @return 商
     */
    public static int divide(int dividend, int divisor) {
        int sum = 0, res = 0;
        if (dividend == 0 | divisor == 0) {
            return 0;
        }
        if (divisor > 0) {
            do {
                sum += divisor;
                res++;
            } while (sum < dividend);
            res -= 1;
        } else if (dividend > 0) {
            do {
                sum += (-divisor);
                res--;
            } while (sum < dividend);
            res += 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int a = 1000, b = 32;
        System.out.println(divide(a, b));
    }
}
