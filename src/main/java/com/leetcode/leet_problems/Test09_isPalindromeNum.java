package com.leetcode.leet_problems;

public class Test09_isPalindromeNum {


    /*
    给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。

    回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
    示例 1：
    输入：x = 121

    输出：true

    示例 2：

    输入：x = -121

    输出：false

    解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

    示例 3：

    输入：x = 10

    输出：false

    解释：从右向左读, 为 01 。因此它不是一个回文数。

    示例 4：

    输入：x = -101

    输出：false

    提示：

    -231 <= x <= 231 - 1

     */

    /**
     * 判断一个数字是否为回文数字
     *
     * @param num 传入数字
     * @return 返回是否为回文数字
     */
    public static boolean isPalindrome(int num) {
        if (num < 0) {
            return false;
        }
        String numStr = String.valueOf(num);
        if (numStr.length() == 1) {
            return true;
        }
        int start = 0;
        int end = numStr.length() - 1;
        while (start < end) {
            if (numStr.charAt(start) == numStr.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
