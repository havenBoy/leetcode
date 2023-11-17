package com.leetcode.leet_problems;

public class Test28_strStr {

    /**
     * 返回一个字符串 needle 在另一个字符串 haystack 中开始的位置，
     * 如果不存在就返回 -1 ，如果 needle 长度是 0 ，就返回 0 。
     * @param haystack 原始字符串
     * @param needle 匹配字符串
     * @return 返回开始位置
     */
    public static int strStr(String haystack, String needle) {
        int result = -1;
        if (needle.isEmpty() || haystack.length() < needle.length()) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
             int index = 0, start = i;
            while (index < needle.length() && haystack.charAt(start) == needle.charAt(index)) {
                index++;
                start++;
            }
            if (index == needle.length()) {
                return i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String string = "hello", str = "hello";
        System.out.println(strStr(string, str));
    }
}
