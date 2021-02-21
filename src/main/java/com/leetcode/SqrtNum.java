package com.leetcode;

public class SqrtNum {

    /**
     * 不使用乘法和除法以及模运算计算除法
     *
     * @param dividend 被除数
     * @param divisor  除数
     * @return 返回商
     */
    public static int divide(int dividend, int divisor) {
        int result;
        if (dividend < 0 && divisor > 0) {
            dividend = -dividend;
            result = (int) dividePre(dividend, divisor);
            result = -result;
        } else if (dividend > 0 && divisor < 0) {
            divisor = -divisor;
            result = (int) dividePre(dividend, divisor);
            result = -result;
        } else if (dividend < 0 && divisor < 0) {
            divisor = -divisor;
            dividend = -dividend;
            result = (int) dividePre(dividend, divisor);
        } else {
            result = (int) dividePre(dividend, divisor);
        }
        return result;
    }

    public static long dividePre(long dividend, long divisor) {
        long res = 0, count = 0;
        while (res <= dividend) {
            res += divisor;
            count += 1;
        }
        return count - 1;
    }

    /***
     * 判断一个数字是否是2的幂次方
     * 最原始的办法，但是时间复杂度太高
     * @param n 输入参数
     * @return 返回是否为2幂次方的布尔值
     */

    public static boolean isPowerOfTwo(int n) {
        int num = 1;
        if (n == 1) return true;
        while (num < n && n % 2 == 0) {
            num = num << 1;
            if (num == n) return true;
        }
        return false;
    }

    /***
     * 判断一个数字是否是3的幂次方
     * 最原始的办法，但是时间复杂度太高
     * @param n  输入参数
     * @return 返回是否为3幂次方的布尔值
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
     * @param n  输入参数
     * @return 返回是否为3幂次方的布尔值
     */

    public static boolean isPowerOfThree2(int n) {
        if (n <= 0) return false;
        double res = Math.log10(n) / Math.log10(3);
		return res % 1 == 0;
	}

    /***
     * 最简单的办法
     * @param n  输入参数
     * @return 返回是否为2幂次方的布尔值
     */
    public static boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    /**
     * 算出一个数字的平方根
     *
     * @param num 输入参数
     * @return 返回平方根值
     */
    public static int sqrt(int num) {
        int k = 0;
        for (long b = num; b >= 1; b /= 2) {
            while ((k + b) * (k + b) <= num) {
                k += b;
            }
        }
        return k;
    }

    /**
     * 二分法计算一个数字的平方根
     *
     * @param num 输入整数
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

    /**
     * 搜索排序数组的左边界与右边界
     *
     * @param nums   待查询数组
     * @param target 目标值
     * @return 返回左右边界的下表，如果不存在，返回{-1，-1}
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int start = 0, end = nums.length - 1;
        //左边界查询方法
        int left = leftSearch(nums, target, start, end);
        //右边界查询
        int right = rightSearch(nums, target, start, end);
        if (left > right) {
            return result;
        }
        result[0] = left;
        result[1] = right;
        return result;
    }

    /**
     * 左边界的定位
     * @param numbs 入参数组
     * @param target 目标值
     * @param start 起始索引值
     * @param end 结束索引值
     * @return 返回左边界下标值
     */
    private static int leftSearch(int[] numbs, int target, int start, int end) {
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (target > numbs[mid]) {
                start = mid + 1;
            } else if (target <= numbs[mid]) {
                end = mid - 1;
            }
        }
        return start;
    }

    /**
     * 右边界的定位
     * @param numbs 入参数组
     * @param target 目标值
     * @param start 起始索引值
     * @param end 结束索引值
     * @return 返回左边界下标值
     */
    private static int rightSearch(int[] numbs, int target, int start, int end) {
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (target < numbs[mid]) {
                end = mid - 1;
            } else if (numbs[mid] <= target) {
                start = mid + 1;
            }
        }
        return end;
    }

    public static void main(String[] args) {

        System.out.println(divide(-2147483648, -1));
        System.out.println(sqrt(2147395599));
        System.out.println(isPowerOfTwo(128));
        System.out.println(isPowerOfThree2(80));

        int[] numbs = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] arr = searchRange(numbs, target);
        System.out.println(arr[0] + "--" + arr[1]);
    }

}
