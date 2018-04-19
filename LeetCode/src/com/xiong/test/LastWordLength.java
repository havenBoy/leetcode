package com.xiong.test;
/**
 * @author 作者:XiaoXiong
 * @version 创建时间：2018年4月19日 下午10:50:59
 * 类说明  给定一个字符串s由大写/小写字母和空白字符组成' '，返回字符串中最后一个单词的长度。
 * eg:输入： “Hello World”
 *    输出： 5
 */
public class LastWordLength {
	
	public static int lengthOfLastWord(String s) {
		return s.trim().length()- 1 - s.trim().lastIndexOf(" ");
	}
	
/*	public static int lengthOfLastWord(String s) {
		int count = 0;
		if (s.charAt(s.length()-1) == ' ') {
			int index = s.length()-1;
			while(index >= 0) {
				if (s.charAt(index) != ' ') {
					for (int i = index; i >= 0; i--) {
						if (s.charAt(i) == ' ' || i == -1) {
							return index - i;
						}
					}
				}
				index--;
			}
		} else {
			for (int i = s.length()-1; i >= 0; i--) {
				if (s.charAt(i) == ' ') {
					break;
				}
				count++;
			}
		}
		return count;
	}*/
	
	public static void main(String[] args) {
		String string = "  ss";
		System.out.println(lengthOfLastWord(string));
	}

}
