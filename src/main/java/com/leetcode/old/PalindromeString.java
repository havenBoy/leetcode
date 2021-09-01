package com.leetcode.old;

/**
 * 
 * 判断一个字符串是否为回文字符串，忽略字符的大小写
 * @author 作者:XiaoXiong
 * @version 创建时间：2018年4月10日 下午9:23:23
 * 类说明
 */
public class PalindromeString {
	
	public static boolean lower(char c) {
		if (('A' <= c && 'z' >= c) || ('0' <= c && '9' >= c)) {
			return c != '`';
		} else {
			return false;
		}
	}
	
	public static char lowerGet(char c) {
		if ('A' <= c && 'Z' >= c) {
			return  (char) (c+32);
		}
		return c;
	}
	
	public static boolean checkString(String string) {
		StringBuilder stringBuilderReverse = new StringBuilder(string).reverse();
		StringBuilder stringBuilderNew = new StringBuilder(string);
		int i = 0,j = 0;
		while (i < stringBuilderReverse.length() && j < stringBuilderReverse.length()) {
			char first = stringBuilderNew.charAt(i);
			char last = stringBuilderReverse.charAt(j);
			if (lower(first) && lower(last)) {
				if (lowerGet(first) == lowerGet(last)) {
					i++;
					j++;
				} else {
					return false;
				}
			} else if (lower(first) && !lower(last)) {
				j++;
			} else if (!lower(first) && lower(last)) {
				i++;
			} else {
				i++;
				j++;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println((byte)('~'));
		System.out.println(checkString("`l;`` 1o1 ??;l`"));
	}

}
