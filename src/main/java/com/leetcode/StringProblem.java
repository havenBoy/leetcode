package com.leetcode;

/**
 * 字符串问题收集
 */
public class StringProblem {

    /**
     * leetcode:7
     * 数字反转，如果发生整数溢出，则返回0
     *
     * @param num 需要反转参数
     * @return 返回反转后的数字
     */
    public static int reverse(int num) {
        int reverseNum = 0;
        while (num != 0) {
            int lastNum = num % 10;
            if (reverseNum > 214748364 || (reverseNum == 214748364 && lastNum > 7)) {
                return 0;
            }
            if (reverseNum < -214748364 || (reverseNum == -214748364 && lastNum < -8)) {
                return 0;
            }
            reverseNum = reverseNum * 10 + lastNum;
            num /= 10;
        }
        return reverseNum;
    }

    public static int myAtoi(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            Character character = str.charAt(i);
            if (character.equals('+') || character.equals('-') || Character.isDigit(character) || character.equals(' ')) {
                if (character.equals('+') || character.equals('-') || character.equals(' ')) {
                    continue;
                }
                if (Character.isDigit(character)) {
                    int num = Integer.valueOf(character.toString());
                    result = result * 10 + num;
                }
            } else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int num = 1099555558;
        System.out.println(reverse(num));

        String str = "-4a12";
        System.out.println(myAtoi(str));

        System.out.println(Character.valueOf('4'));
    }
}
