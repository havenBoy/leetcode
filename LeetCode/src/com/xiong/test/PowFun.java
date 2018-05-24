package com.xiong.test;

public class PowFun {
	
	/**
	 * 整数的反转
	 * @param x
	 * @return
	 */
	public static int reverse(int x) {
		long result = 0;
		long num = x;
		if(num < 0) num = -num;
		if(num > Integer.MAX_VALUE) return 0;
		while(num >= 1) {
			result = num % 10 + result * 10;
			num /= 10;
		}
		result = result > Integer.MAX_VALUE ? 0 : result;
		result = x < 0 ? -result : result;
		return (int)result;
	}
	
	/**
	 * Implement pow(x, n).
	 *	Example 1:
	 * 	Input: 2.00000, 10
	 *	Output: 1024.00000
	 *	Example 2:
	 *	Input: 2.10000, 3
	 *	Output: 9.26100
	 * */
	
	public static double powfun(double num,int n) {
		if (n == 0)
			return 1;
		if (n < 0) {
			num = 1/num;
			n = -n;
		} 
		return (n%2 == 0) ? powfun(num*num, n/2) : num*powfun(num*num, n/2);
	}
	
	/**
	 * 判断一个字符串可以转化为数字
	 * @param s
	 * @return
	 */
	public static boolean isNumber(String s) {
		return s.matches("^\\s*[-+]?((\\d+(\\.\\d*)?)|(\\.\\d+))(e[-+]?\\d+)?\\s*$");
	}

	
	public static void main(String[] args) {
		System.out.println(reverse(-1563847412));
		System.out.println(isNumber("2e10"));
		System.out.println(powfun(3.00, 5));
		System.out.println(powfun(3.00, 0));
		System.out.println(powfun(3.00, -5));
	}

}
