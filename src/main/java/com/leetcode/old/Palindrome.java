package com.leetcode.old;

public class Palindrome {
	
	/**
	 * 回文数的判断  
	 * @param num 待处理参数
	 * @return 返回状态值
	 */
	
	public static boolean checkPalindrome(int num) {
		StringBuilder stringBuilder = new StringBuilder(Integer.toString(num)).reverse();
		StringBuilder string = new StringBuilder(Integer.toString(num));
		for (int i = 0; i < stringBuilder.length(); i++) {
			if (stringBuilder.charAt(i) != string.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		int num = -1221;
		System.out.println(checkPalindrome(num));
	}

}
