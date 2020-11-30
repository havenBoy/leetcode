package com.leetcode;

import java.util.Arrays;

/***
 * 思路：
 * 判断一个数字是否为素数，
 * 遍历N能否能被从2到sqrt(N)之间的素数整除，不能即为素数
 * 为什么是sqrt(N)而不是N?因为n/sqrt(N) <= sqrt(n)
 * 找出所有小于n的素数
 */
public class CountPrimes {
	/***
	 * 依次判断，时间复杂度度较高
	 * @param num
	 * @return
	 */
	public static boolean isPrimes(int num) {
		if(num <= 1) return false;
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static int countPrimes(int n) {
		int count=0;
	       for(int i=2;i<=n;i++) {
	           if(isPrimes(i))  count++;
	       }
	    return count;
	}
	/***
	 * 依次标记遍历数字的整数倍，标记后这个数字表示不是素数
	 * @param n
	 * @return
	 */
	public static int countPrimes2(int n) {
		boolean[] prime = new boolean[n];
		if (n < 2) return 0;
        int count = n;
        Arrays.fill(prime, true);
        for(int i = 2; i < n; i++){
            if(prime[i]){
                for(int j = i * 2; j < n; j =  j + i){
                	if (prime[j] == true) {
						count--;
					}
                    prime[j] = false;
                }
            }
        }
        return count-2;//0，1不算
	}
	
	public static void main(String[] args) {
		System.out.println(countPrimes(200));
		System.out.println(countPrimes2(200));
	}

}
