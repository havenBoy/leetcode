package com.leetcode.old;

import java.util.Arrays;

/**
 * KMP算法描述
 *
 * @author 作者:XiaoXiong
 */
public class Test06 {

    /** leetcode:14
     * 找出字符串数组中的最大公共字符串
     * 如果没有公共字符串，则返回空字符串
     * 思路：将第一个字符串当做符合条件返回的字符串
     * 如果不满足，逐渐收缩当前字符串，使得满足条件
     * 返回即为结果字符串
     * @param strs 字符串数组
     * @return 返回最长相同前缀字符串
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(res) != 0) {
                res = res.substring(0, res.length() - 1);
            }
        }
        return res;
    }

    /**
     *
     * @return
     */
    public static int mySqrt(int num) {
        int start = 0, end = num;
        while (start <= end) {
            int result = (start + end) / 2;
            if (result * result == num) {
                return result;
            } else if (result * result > num) {
                end--;
            } else {
                start++;
            }
        }
        return end;
    }

    /**
     * 计算最后一个单词的长度，假设字符串只有字母与空格组成
     * 思路：
     * 从字符串的末尾开始遍历，只要经过不为空格的字母开始算起，直到遍历到字符串的起始
     *
     * @param str 原始字符串
     * @return 最后一个单词的长度
     */
    public static int getLastWordLen(String str) {
        int len = str.length() - 1;
        int count = 0;
        boolean flag = false;
        while (len >= 0) {
            Character character = str.charAt(len);
            if (!character.equals(' ')) {
                count++;
                flag = true;
            } else if (flag) {
                break;
            }
            len--;
        }
        return count;
    }

    /**
     * 暴力匹配字符串
     * 思路：
     *
     * @param string  原始字符串
     * @param pattern 匹配字符串
     * @return 返回首次匹配下标
     */
    public static int hardMatch(String string, String pattern) {
        int strLen = string.length();
        int pLen = pattern.length();

        int i = 0, j = 0;

        while (i < strLen && j < pLen) {
            if (string.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }

        if (j == pLen) {
            return i - j;
        } else {
            return -1;
        }
    }

    /**
     * KMP匹配算法
     * 思路:
     *
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
     *
     * @param pattern 匹配字符串
     * @return 返回数组
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

    /**
     * 判断一个字符串是否为回文串，只需要考虑字母与数字
     *
     * @param str
     * @return 是否为回文数字
     */
    public static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            Character startCharacter = str.charAt(start);
            Character endCharacter = str.charAt(end);
            if (Character.toLowerCase(startCharacter) == Character.toLowerCase(endCharacter)) {
                start++;
                end--;
            } else if (!Character.isLetter(startCharacter) && !Character.isDigit(startCharacter)) {
                start++;
            } else if (!Character.isLetter(endCharacter) && !Character.isDigit(endCharacter)) {
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] str = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(str));

        String longString = "mississippi";
        String pattern = "issip";

        System.out.println(hardMatch(longString, pattern));
        System.out.println(kmpMatch(longString, pattern));

        String string = "    Hello World ";
        System.out.println(getLastWordLen(string));

        Character character1 = 'A';
        Character character2 = 'a';

        System.out.println(character1.toString().equalsIgnoreCase(character2.toString()));

        String str11 = "A man, a plan, a canal: Panama";
        String str22 = "a32a";

        System.out.println(isPalindrome(str22));

        int num = 10;
        System.out.println(mySqrt(2147395599));
    }

}
