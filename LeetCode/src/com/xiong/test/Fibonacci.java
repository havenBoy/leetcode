package com.xiong.test;

/**
 * 斐波那契数列的计算
 * @param n
 * @return
 */
public class Fibonacci {
	
	//需要考虑n足够大时，返回值溢出问题

	//递归
	public static int fibonacci1(int n) {
		if(n <= 1 ) 
			return n;
		return fibonacci1(n-2) + fibonacci1(n-1);
	}
	
	
	//非递归
	public static int Fibonacci2(int n) {
		int[] array = new int[n+1];
		array[0] = 0;
		array[1] = 1;
		for(int i = 2; i <= n; i++) {
			array[i] = array[i-1] + array[i-2];
		}
		return array[n];
	}
	
	
	public static void main(String[] args) {
		System.out.println(fibonacci1(10));
		System.out.println(Fibonacci2(10));
	}
}
