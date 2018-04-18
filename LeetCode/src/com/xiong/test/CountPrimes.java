package com.xiong.test;
/***
 * 找出所有小于n的素数
 * 思路：
 * @author Eric
 */
public class CountPrimes {
	
	public static boolean isPrimes(int num) {
		boolean flag = false;
		for (int i = 2; i < Math.sqrt(num); i++) {
			if (num % i != 0) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	
	public static int countPrimes(int n) {
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(isPrimes(5));
	}

}
