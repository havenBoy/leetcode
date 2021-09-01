package com.leetcode.problems;

public class Test14_longestCommonPrefix {

    /**
     * 找出字符串数组中的最大公共字符串
     * 如果没有公共字符串，则返回空字符串
     * 思路：将第一个字符串当做符合条件返回的字符串
     * 如果不满足，逐渐收缩当前字符串，使得满足条件
     * 返回即为结果字符串
     *
     * @param strings 字符串数组
     * @return 返回最长相同前缀字符串
     */
    public static String longestCommonPrefix(String[] strings) {
        if (strings.length == 0) return "";
        String res = strings[0];
        for (int i = 1; i < strings.length; i++) {
            while (strings[i].indexOf(res) != 0) {
                res = res.substring(0, res.length() - 1);
            }
        }
        return res;
    }

}
