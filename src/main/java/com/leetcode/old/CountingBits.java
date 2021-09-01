package com.leetcode.old;

/**
 * @author 作者:XiaoXiong
 * @version 创建时间：2018年4月23日 下午9:04:26
 * 类说明  计算每个数字二进制中1的个数  n&(n-1) 可以消除最低位的1
 * **把一个数字的二进制反转，返回新的数字
 * 不使用+ - 计算2数之和
 */
public class CountingBits {
	
	
	public static int sum(int a, int b) {
		if (b == 0) return a;
		int sum = a ^ b;
		int carry = (a & b) << 1;
		return sum(sum, carry);
	}
	
	
	public static int reverseBit(int n) {
		int res = 0;
        for(int i = 0; i < 32; i++, n >>= 1){
            res = res << 1 | (n & 1);
        }
        return res;
	}
	
	public static int[] countBits(int n) {
		int[] array = new int[n+1];
		for (int i = 0; i <= n; i++) {
			array[i] = count(i);
		}
		return array;
	}
	
	public static int count(int n) {
		int count = 0;
		while (n != 0) {
			n = n & (n-1);
			count++;
		}
		return count;
	}

}
