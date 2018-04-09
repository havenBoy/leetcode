package com.xiong.test;

import java.util.Stack;

/**
 * @author 作者:XiaoXiong
 * @version 创建时间：2018年4月9日 下午9:30:33
 * 类说明
 */
public class validChacater {
	
	
	/**
	 * 验证括号的匹配性
	 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
       The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
	 * @param string
	 * @return
	 */
	
	public static boolean checkValid(String string) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == '{') {
				stack.push('}');
			} else if (string.charAt(i) == '[') {
				stack.push(']');
			} else if (string.charAt(i) == '(') {
				stack.push(')');
			} else if (stack.isEmpty() || !(stack.pop() == string.charAt(i))) {
				return false;
			}
		}
		return stack.isEmpty();
	}

}
