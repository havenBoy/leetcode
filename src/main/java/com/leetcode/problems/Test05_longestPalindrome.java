package com.leetcode.problems;

public class Test05_longestPalindrome {

    /*
     * 题目描述
     *
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * 示例 1：
     *
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案
     * 示例 2：
     *
     * 输入：s = "cbbd"
     * 输出："bb"
     */

    public static boolean lower(char c) {
        if (('A' <= c && 'z' >= c) || ('0' <= c && '9' >= c)) {
            return c != '`';
        } else {
            return false;
        }
    }

    public static char lowerGet(char c) {
        if ('A' <= c && 'Z' >= c) {
            return (char) (c + 32);
        }
        return c;
    }

    public static boolean checkString(String string) {
        StringBuilder stringBuilderReverse = new StringBuilder(string).reverse();
        StringBuilder stringBuilderNew = new StringBuilder(string);
        int i = 0, j = 0;
        while (i < stringBuilderReverse.length() && j < stringBuilderReverse.length()) {
            char first = stringBuilderNew.charAt(i);
            char last = stringBuilderReverse.charAt(j);
            if (lower(first) && lower(last)) {
                if (lowerGet(first) == lowerGet(last)) {
                    i++;
                    j++;
                } else {
                    return false;
                }
            } else if (lower(first) && !lower(last)) {
                j++;
            } else if (!lower(first) && lower(last)) {
                i++;
            } else {
                i++;
                j++;
            }
        }
        return true;
    }
}
