package com.leetcode.leet_problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Test03_lengthOfLongestSubstring {

    /*
     * 题目描述：
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
     *
     */

    /**
     * 无重复字符的最长字符串长度
     *
     * @param str 传入字符串
     * @return 返回是否为回文数字标志
     */
    public static int lengthOfLongestSubstring(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            Set<Character> set = new HashSet<Character>();
            set.add(str.charAt(i));
            for (int j = i + 1; j < str.length(); j++) {
                Character character = str.charAt(j);
                if (set.contains(character)) {
                    break;
                } else {
                    set.add(character);
                }
            }
            result = Math.max(result, set.size());
        }
        return result;
    }

    /**
     * 最大的不重复子串
     *
     * @param s 输入字符串
     * @return 最大不重复子串长度
     */
    public static int lengthOfLongestSubstring2(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(10);
        int maxLen = 0;
        //滑动窗口左指针
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            //left的下标取值为重复字符的下表+1
            if (map.containsKey(character)) {
                left = Math.max(left, map.get(character) + 1);
            }
            //更新character的位置
            map.put(character, i);
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }

    /**
     * 无重复字符的最长字符串
     *
     * @param str 传入字符串
     * @return 返回是否为回文数字标志
     */
    public static int LongestSubstring(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            Set<Character> set = new HashSet<Character>();
            set.add(str.charAt(i));
            for (int j = i + 1; j < str.length(); j++) {
                Character character = str.charAt(j);
                if (set.contains(character)) {
                    break;
                } else {
                    set.add(character);
                }
            }
            result = Math.max(result, set.size());
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "abcacb";

        System.out.println(lengthOfLongestSubstring(str));
        System.out.println(lengthOfLongestSubstring2(str));

        String a1 = "abc";
        String a2 = "acb";
        System.out.println(a1.compareTo(a2));

    }
}
