package com.leetcode.old;

import java.util.Stack;

/**
 * 栈结构问题
 */
public class StackProblem {

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

    public static boolean validString(String string) {
        int length = string.length();
        if (length % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < length; i++) {
            Character character = string.charAt(i);
            if (character == '{' || character == '[' || character == '(') {
                stack.push(character);
            } else {
				if (stack.isEmpty()) {
					return false;
				}
                Character popChar = stack.pop();
                if (popChar == '{' && character != '}') {
                    return false;
                } else if (popChar == '[' && character != ']') {
                    return false;
                } else if (popChar == '(' && character != ')') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String string = "{}[{}]";
        System.out.println(validString(string));
    }

}
