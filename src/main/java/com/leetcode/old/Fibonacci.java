package com.leetcode.old;

/**
 * 斐波那契数列的计算  以及举一反三
 * @param n
 * @return
 */
public class Fibonacci {
	
	public static int count1 = 0;
	public static int count2 = 0;
	public static int count3 = 0;
	
	public static int num = 10;
	
	public static int[] arr = new int[num+1];
	//三数最大
	public static int max3 (int a, int b, int c) {
		return Math.max(a, Math.max(c, b));
	}
	
	//需要考虑n足够大时，返回值溢出问题

	//递归
	public static int fibonacci1(int n) {
		count1++;
		if(n <= 1 ) 
			return n;
		return fibonacci1(n-2) + fibonacci1(n-1);
	}
	
	
	//记忆数组
	public static int fibonacci3(int n) {
		count3 ++ ;
		if(n <= 1 ) 
			return n;
		if(arr[n] == -1)
			arr[n] = fibonacci3(n-1) + fibonacci3(n-2);
		return arr[n];
	}
	
	//非递归    效率明显较高
	public static int fibonacci2(int n) {
		count2++;
		int[] array = new int[n+1];
		array[0] = 0;
		array[1] = 1;
		for(int i = 2; i <= n; i++) {
			array[i] = array[i-1] + array[i-2];
		}
		return array[n];
	}
	
	//把一个数字转化为至少2个数字的和，使得乘积最大
    public static int integerBreak(int n) {
        if( n == 1) 
        	return n;
        int res  = -1;
        for (int i = 1; i <= n -1; i++) {
			res = max3(res, i * (n-i), i * integerBreak(n-i));
		}
        return res;
    }
	
	
	public static void main(String[] args) {
		for (int i = 0; i <= num; i++) {
			arr[i] = -1;
		}
		long startTime=System.nanoTime();   //获取开始时间
		System.out.println(fibonacci1(num));
		long endTime=System.nanoTime();   //获取结束时间
		System.out.println("(1)用时间：" + (endTime-startTime) + "纳秒；" + count1);
		startTime = System.nanoTime();
		System.out.println(fibonacci2(num));
		endTime = System.nanoTime();
		System.out.println("(2)用时间：" + (endTime-startTime) + "纳秒；" + count2);
		startTime=System.nanoTime();   //获取开始时间
		System.out.println(fibonacci3(num));
		endTime=System.nanoTime();   //获取结束时间
		System.out.println("(3)用时间：" + (endTime-startTime) + "纳秒；" + count3);
		
		//整数分解
		System.out.println(integerBreak(10));
	}
}
