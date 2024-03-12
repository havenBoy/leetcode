package com.leetcode.leet_problems;

public class Test91_numbDecoding {

    /**
     * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。
     * 例如，"11106" 可以映射为
     * "AAJF" ，将消息分组为 (1 1 10 6)
     * "KJF" ，将消息分组为 (11 10 6)
     * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，
     * 这是由于 "6" 和 "06" 在映射中并不等价。
     * 给你一个只含数字的非空字符串 s ，请计算并返回解码方法的总数
     * 例如 226 可以有三种，2|2|6，22|6，2|26
     * @param s 给出一个字符串
     * @return 返回拆法的个数
     */
    public static int numbDecoding(String s) {
        int length = s.length();
        if (s.length() == 1) {
            if (s.charAt(0) != '0') {
                return 1;
            } else {
                return 0;
            }
        }
        if (s.length() == 2) {
            if (s.charAt(0) != '0' && s.charAt(1) == '0') {
                if (s.charAt(0) <= '2') {
                    return 1;
                }
            } else if (s.charAt(0) != '0' && s.charAt(1) != '0') {
               return 1;
            }
            return 0;
        }
        return numbDecoding(s.substring(0, length-2))
                + (numbDecoding(s.substring(length-1)) + numbDecoding(s.substring(length-2, s.length()-1)) == 2 ? 0 : 1)
                + numbDecoding(s.substring(length-2));
    }

    /**
     * 思路：
     * 如果对于字符串的f(i)处的字符，如果此字符串单独成解法，则要求前置字符不为0
     * 如果对于f(i-1)与f(i)成解法，则要求f(i-1)不为0，且连接后转数字不能大于26
     * @param s 给定的字符串
     * @return 返回解法个数
     */
    public static int numbDecoding2(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                f[i] = f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && Integer.parseInt(s.substring(i - 2, i)) <= 26) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        String str = "206";
        System.out.println(numbDecoding2(str));
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
    }
}
