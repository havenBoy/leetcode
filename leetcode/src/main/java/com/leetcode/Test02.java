package com.leetcode;

/**
 * 斐波那契数列，递归
 * @version 2.0.0
 * @author 赵小雄59782
 * @date 2020/11/30 11:23
 */
public class Test02 {

    public static int fibonacii(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacii(n - 1) + fibonacii(n - 2);
    }

    public static int finbonaci2(int n) {
        if (n == 0) {
            return 0;
        }
        int first = 1, second = 1;

        int result  = 1;
        if (n == 1 || n == 2) {
            return 1;
        }
        for (int i = 3; i <= n; i++) {
            int tmp = second;
            second = first + second;
            first = tmp;
        }
        return second;
    }

    public static void main(String[] args) {

        System.out.println(fibonacii(6));

        System.out.println(finbonaci2(6));
    }

}
