package com.xiong.test;

public class UglyNum {
	
	/***
	 * 判断一个数字是否为丑数，即质数因子只有2,3,5
	 * 思路：不断的除以这几个质数，如果结果为1则是，否则不是，注意0不是
	 * @param num
	 * @return
	 */
	
	public static boolean isUgly(int num) {
		if (num == 0) return false;
		while (num != 1) {
			if (num%2 == 0) {
				num/=2;
			} else if (num%3 == 0) {
				num/=3;
			} else if (num%5 == 0) {
				num/=5;
			} else {
				return false;
			}
		}
		return true;
	}
	
	/***
	 * 第n个丑数，从1开始算起，1也是丑数  时间复杂度较大，测试用例不通过
	 * @param n
	 * @return
	 */
	public static int nthUglyNumber(int n) {
		if (n == 1) return 1;
		int count = 1,num = 1;
		while (count != n) {
			num++;
			if (isUgly(num)) count++;
			if (n == count) break;
 		}
		return num;
	}
	
	public static int nthUglyNumber2(int n) {
		int[] nums = new int[n];
		int num1 = 2, num2 = 3, num3 = 5;
		int index1 = 0, index2 = 0, index3 = 0;
		nums[0] = 1;
		for (int i = 1; i < n; i++) {
			int min = Math.min(num1, Math.min(num2, num3));
			nums[i] = min;
			if(min == num1) num1 = 2 * nums[++index1];
			if(min == num2) num2 = 3 * nums[++index2];
			if(min == num3) num3 = 5 * nums[++index3];
		}
		return nums[n-1];		
	}
	
	public static void main(String[] args) {
		 System.out.println(isUgly(11));
		 System.out.println(nthUglyNumber(100));
		 System.out.println(nthUglyNumber2(10));
	}

}
