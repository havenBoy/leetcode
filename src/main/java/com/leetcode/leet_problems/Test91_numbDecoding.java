package com.leetcode.leet_problems;

public class Test91_numbDecoding {

    /**
     * 1 ->A
     * 2-> B
     * ......
     * 每个数字对应一个字母，给一串数字，问有几种解码方式
     * 例如 226 可以有三种，2|2|6，22|6，2|26
     * @param s 给出一个链表
     * @return 返回去重后的链表
     */
    public static int numbDecodings(String s) {
        if (s.length() == 1 && s.charAt(0) != '0') {
            System.out.println(s);
            return 1;
        }
        if (s.length() == 2) {
            System.out.println(s);
            int sum = 0;
            if (s.charAt(0) != '0' && s.charAt(1) == '0') {
                if (s.charAt(0) <= '2') {
                    sum += 1;
                }
            } else if (s.charAt(0) != '0' && s.charAt(1) != '0') {
                sum += 1;
            }
            return sum;
        }
        return numbDecodings(s.substring(0, s.length()-2)) + numbDecodings(s.substring(0, s.length()-1));
    }

    public static void main(String[] args) {
        String str = "2274";
        System.out.println(numbDecodings(str));
    }
}
