package com.leetcode.leet_problems.String;

public class Test65_isNumber {

    /**
         小数（按顺序）可以分成以下几个部分：
         （可选）一个符号字符（'+' 或 '-'）
         下述格式之一：
         至少一位数字，后面跟着一个点 '.'
         至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
         一个点 '.' ，后面跟着至少一位数字
         整数（按顺序）可以分成以下几个部分：
         （可选）一个符号字符（'+' 或 '-'）
         至少一位数字
     *
     * @param str 字符串
     * @return 返回是否为数字的布尔值
     */
    public static boolean isNumber(String str) {
        if (str.isEmpty()) {
            return false;
        }
        str = str.toLowerCase();
        if (str.startsWith("-") || str.startsWith("+")) {
            str = str.substring(1);
        }
        if (str.isEmpty()) {
            return false;
        }
        if (!str.contains(".")) {
            if (!str.contains("e")) {
                return checkDigital(str);
            } else {
                return checkDigitalWithE(str);
            }
        } else {
            if (!str.contains("e")) {
                return checkDecimal(str);
            } else {
                return checkDecimalWithE(str);
            }
        }
    }

    /**
     * 校验整数
     */
    public static boolean checkDigital(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 校验整数,包含E
     * 规则：e只能出现一次，且不能出现在第一位与最后一位
     */
    public static boolean checkDigitalWithE(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'e') {
                count++;
            } else if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return str.charAt(0) != 'e' && str.charAt(str.length()-1) != 'e' && count == 1;
    }

    /**
     * 校验小数  不带有E
     *          至少一位数字，后面跟着一个点 '.'
     *          至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
     *          一个点 '.' ，后面跟着至少一位数字
     */
    public static boolean checkDecimal(String str) {
        int count = 0;
        if (str.startsWith(".")) {
            str = str.substring(1);
            if (str.isEmpty()) {
                return false;
            }
            for (int i = 0; i < str.length(); i++) {
                if(!Character.isDigit(str.charAt(i))) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '.') {
                    count++;
                } else if (!Character.isDigit(str.charAt(i))) {
                    return false;
                }
            }
        }
        return str.charAt(0) != '.' && str.charAt(str.length()-1) != '.' && count == 1;
    }

    /**
     * 校验小数  不带有E
     * 至少一位数字，后面跟着一个点 '.'
     * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
     * 一个点 '.' ，后面跟着至少一位数字
     */
    public static boolean checkDecimalWithE(String str) {
        int count = 0, countE = 0;
        if (str.startsWith(".")) {
            str = str.substring(1);
            return checkDigitalWithE(str);
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '.') {
                    count++;
                } else if (str.charAt(i) == 'e') {
                    countE++;
                } else if (!Character.isDigit(str.charAt(i))) {
                    return false;
                }

            }
        }
        int indexSplit = str.indexOf("."), indexE = str.indexOf("e");
        return str.charAt(0) != '.' && str.charAt(str.length()-1) != '.' && count == 1 && countE == 1 && str.charAt(0) != 'e' && str.charAt(str.length()-1) != 'e' && indexSplit < indexE;
    }

    public static void main(String[] args) {
        String str = "1.";
        System.out.println(isNumber(str));
        System.out.println(Double.parseDouble(str));
    }
}
