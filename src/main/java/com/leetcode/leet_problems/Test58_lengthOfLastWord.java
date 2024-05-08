package com.leetcode.leet_problems;

public class Test58_lengthOfLastWord {

    /**
     * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
     * 如果不存在最后一个单词，请返回 0 。
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
            if (str.charAt(i) == ' ') {
                break;
            }
            result++;
        }
        return result;
    }

    /**
     * 根据空格进行字符串的切割
     * @param str 输入字符串
     * @return 返回最后一个非空字符串的长度
     */
    public static int lengthOfLastWord2(String str) {
        String[] split = str.split(" ");
        if (split.length == 0) {
            return 0;
        }
        String lastWord = split[split.length - 1];
        return lastWord.length();
    }

    public static void main(String[] args) {
        String str = "     ";
//        String str = "hello world   ";
        System.out.println(lengthOfLastWord(str));
        System.out.println(lengthOfLastWord2(str));
    }
}
