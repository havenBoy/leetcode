package com.leetcode.leet_problems;

public class Test58_lengthOfLastWord {

    /**
     * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
     *
     * @param str 输入字符串
     * @return 返回最后一个字符串的长度
     */
    public static int lengthOfLastWord(String str) {
        int result = 0;
        if (str.isEmpty()) {
            return result;
        }
        int length = str.length() - 1;
        while (str.charAt(length) == ' ' && length > 0) {
            length--;
        }
        for (int i = length; i >= 0; i--) {
            if (str.charAt(i) != ' ') {
                result++;
            } else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "     ";
//        String str = "hello world   ";
        System.out.println(lengthOfLastWord(str));
    }
}
