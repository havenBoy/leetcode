package com.leetcode;

public class SqurtNum {
	
	/**
	 * 不使用乘法和除法以及模运算计算除法
	 * @param dividend
	 * @param divisor
	 * @return
	 */
    public static int divide(int dividend, int divisor) {
    	int result = 0;
        if (dividend < 0 && divisor > 0) {
			dividend = -dividend;
			result = (int)dividePre(dividend, divisor);
			result = -result;
		} else if (dividend > 0 && divisor < 0){
			divisor = -divisor;
			result = (int)dividePre(dividend, divisor);
			result = -result;
		} else if (dividend < 0 && divisor < 0) {
			divisor = -divisor;
			dividend = -dividend;
			result = (int)dividePre(dividend, divisor);
		} else {
	        result = (int)dividePre(dividend, divisor);
		}
        return result;
    }
    
    public static long dividePre(long dividend, long divisor) {
    	long res = 0,count = 0;
		while (res <= dividend) {
			res += divisor;
			count+= 1;
		}
		return count-1;
	}
	
	/***
	 * 判断一个数字是否是2的幂次方
	 * 最原始的办法，但是时间复杂度太高
	 * @param n
	 * @return
	 */
	
	public static boolean isPowerOfTwo(int n) {
		int num = 1;
		if (n == 1) return true;
		while (num < n && n %2 == 0) {
			num = num << 1;
			if (num == n) return true;
		}
		return false;
	}
	
	/***
	 * 判断一个数字是否是3的幂次方
	 * 最原始的办法，但是时间复杂度太高
	 * @param n
	 * @return
	 */
	
	public static boolean isPowerOfThree(int n) {
		if (n == 0) return false;
		if (n == 1) return true;
		while (n % 3 == 0) {
			n = n / 3;
			if (1 == n) return true;
		}
		return false;
	}
	
	/***
	 * 判断一个数字是否是3的幂次方
	 * 最快的办法
	 * @param n
	 * @return
	 */
	
	public static boolean isPowerOfThree2(int n) {
		if (n <= 0) return false;
		double res = Math.log10(n)/Math.log10(3);
		if (res % 1 == 0) {
			return true;
		}
		return false;
	}
	
	/***
	 * 最简单的办法
	 * @param n
	 * @return 
	 */
	public static boolean isPowerOfTwo2(int n) {
		
		return n > 0 ? (n & (n-1)) == 0 : false;
	}

	/** 错误示例
	 * @param num
	 * 算出一个数字的平方根（二分法查找的时间复杂度依然较高）
	 */
//	public static int getSqrt(int num) {
//		int low = 1,high = num;
//		while(low <= high) {
//			int x = (low + high)/2;
//			if (x*x == num) {
//				return x;
//			} else if (x*x > num){
//				high = x-1;
//			} else {
//				low = x+1;
//			}
//		}
//		return high;
//	}
	/**
	 * 算出一个数字的平方根
	 * @param num
	 * @return
	 */
	public static int sqrt(int num) {
		int k = 0;
	    for (long b = num; b >= 1; b /= 2) {
	        while ( (k+b)*(k+b) <= num) {
				k += b;
			}
	    }
	    return k;
	}
	/**
	 * 二分法计算一个数字的平方根
	 * @param num  输入整数
	 * @return 返回平方根
	 */
	public static int mySqrt(int num) {
		if (num <= 1) {
			return num;
		}
		int start = 0, end = num;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (mid == num / mid) {
				return mid;
			} else if (mid > num / mid) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return start - 1;
	}

	public static void main(String[] args) {

		System.out.println(divide(-2147483648, -1));
		System.out.println((2^31-1) < 2147395599);
		System.out.println(sqrt(2147395599));
		//System.out.println(isPowerOfTwo(128));
		//System.out.println(isPowerOfThree2(80));

		System.out.println(mySqrt(2));
	}

}
