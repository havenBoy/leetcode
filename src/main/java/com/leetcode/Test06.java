package com.leetcode;

import java.util.Arrays;

/**
 * KMP算法描述
 * @author 作者:XiaoXiong
 * @version
 */
public class Test06 {

    /**
     * 找出字符串数组中的最大公共字符串
     * 如果没有公共字符串，则返回空字符串
     * 思路：
     * @param strs  字符串数组
     * @return 返回最长相同前缀字符串
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(res) != 0)
                res = res.substring(0, res.length() - 1);
        }
        return res;
    }

    /**
     * 暴力匹配字符串
     * 思路：
     * @param string  原始字符串
     * @param pattern 匹配字符串
     * @return 返回首次匹配下标
     */
    public static int hardMatch(String string, String pattern) {
        int strLen = string.length();
        int plen = pattern.length();

        int i = 0, j = 0;

        while (i < strLen && j < plen) {
            if (string.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = 0;
                i = i - j + 1;
            }
        }

        if (j == plen) {
            return i - j + 1;
        } else {
            return -1;
        }
    }

    /**
     * KMP匹配算法
     * 思路:
     * @param string  原始字符串
     * @param pattern 匹配字符串
     * @return 返回首次匹配的下标
     */
    public static int kmpMatch(String string, String pattern) {
        int strLen = string.length();
        int plen = pattern.length();

        int i = 0, j = 0;
        int[] next = getNext(pattern);

        while (i < strLen && j < plen) {
            if (j == -1 || string.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == plen) {
            return i - j + 1;
        } else {
            return -1;
        }

    }

    /**
     * 获取下一次j偏移的位置
     * 思路：
     * @param pattern  匹配字符串
     * @return  返回数组
     */
    public static int[] getNext(String pattern) {
        int len = pattern.length();
        int[] next = new int[len];
        int k = -1, j = 0;
        next[0] = -1;
        while (j < len - 1) {
            if (k == -1 || pattern.charAt(j) == pattern.charAt(k)) {
                if (pattern.charAt(++j) == pattern.charAt(++k)) {
                    next[j] = next[k];
                } else {
                    next[j] = k;
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String[] str = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(str));

        String longString = "ABCCABCD";
        String pattern = "ABCD";

        System.out.println(hardMatch(longString, pattern));
        System.out.println(kmpMatch(longString, pattern));
    }

}