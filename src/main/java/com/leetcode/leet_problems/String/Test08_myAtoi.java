package com.leetcode.leet_problems.String;

public class Test08_myAtoi {

    /*
    请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）
    函数myAtoi(string s) 的算法如下：
    读入字符串并丢弃无用的前导空格
    检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
    读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
    将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）
    返回整数作为最终结果。
    注意：

    本题中的空白字符只包括空格字符 ' ' 。
    除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。

    示例1：
    输入：s = "42"
    输出：42
    解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符
    第 1 步："42"（当前没有读入字符，因为没有前导空格）
    第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
    第 3 步："42"（读入 "42"）
    解析得到整数 42 。
    由于 "42" 在范围 [-231, 231 - 1] 内，最终结果为 42
    示例2：

    输入：s = "   -42"
    输出：-42
    解释：
    第 1 步："   -42"（读入前导空格，但忽视掉）
    第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
    第 3 步："   -42"（读入 "42"）
    解析得到整数 -42
    由于 "-42" 在范围 [-231, 231 - 1] 内，最终结果为 -42
    示例3：

    输入：s = "4193 with words"
    输出：4193
    解释：
    第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
    第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
    第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
    解析得到整数 4193 。
    由于 "4193" 在范围 [-231, 231 - 1] 内，最终结果为 4193
    示例4：

    输入：s = "words and 987"
    输出：0
    解释：
    第 1 步："words and 987"（当前没有读入字符，因为没有前导空格）
    第 2 步："words and 987"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
    第 3 步："words and 987"（由于当前字符 'w' 不是一个数字，所以读入停止）
    解析得到整数 0 ，因为没有读入任何数字。
    由于 0 在范围 [-231, 231 - 1] 内，最终结果为 0
    示例5：

    输入：s = "-91283472332"
    输出：-2147483648
    解释：
    第 1 步："-91283472332"（当前没有读入字符，因为没有前导空格）
    第 2 步："-91283472332"（读入 '-' 字符，所以结果应该是负数）
    第 3 步："-91283472332"（读入 "91283472332"）
    解析得到整数 -91283472332
    由于 -91283472332 小于范围 [-231, 231 - 1] 的下界，最终结果被截断为 -231 = -2147483648
    提示：
    0 <= s.length <= 200
    s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
    */

    /**
     * 字符串转数字  遇到正负以及空格跳过，
     * 从第一个不为字母的数字开始，到不为数字结束
     *
     * @param str 入参字符串
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

}
