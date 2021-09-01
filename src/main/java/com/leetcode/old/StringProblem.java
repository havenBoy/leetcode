package com.leetcode.old;

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

    /**
     * 字符串转数字  遇到正负以及空格跳过，
     * 从第一个不为字母的数字开始，到不为数字结束
     * @param str  入参字符串
     * @return 返回有效的整型数字
     */
    public static int myAtoi(String str) {
        int result = 0;
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            Character character = str.charAt(i);
            if (character.equals('+') || character.equals('-')
                    || Character.isDigit(character) || character.equals(' ')) {
                if (character.equals('+') || character.equals('-') || character.equals(' ')) {
                    if (result != 0) {
                        break;
                    } else {
                        if (character.equals('-')) {
                            flag = false;
                        }
                        continue;
                    }
                }
                if (Character.isDigit(character)) {
                    int num = Character.getNumericValue(character);
                    if (flag) {
                        if (result > 214748364 || (result == 214748364 && num > 7)) {
                            result = Integer.MAX_VALUE - 1;
                            return result;
                        }
                    } else {
                        if (result > 214748364 || (result == 214748364 && num > 7)) {
                            return -Integer.MAX_VALUE - 1;
                        }
                    }
                    result = result * 10 + num;
                }
            } else {
                break;
            }
        }
        return flag ? result : -result;
    }

    public static void main(String[] args) {

        int num = 1099555551;
        System.out.println(reverse(num));

        String str = "-+12";
        System.out.println(myAtoi(str));

        int aa = -2147483648;
        System.out.println(aa);
    }
}
