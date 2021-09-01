### 两数之和

- 题目描述

  ~~~txt
  给定一个整数数组 nums和一个整数目标值 target，
  请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。 
  你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
  你可以按任意顺序返回答案。
  ~~~

- 暴力枚举
  - 算法描述
    枚举每一个数组中的元素x,查看是否存在元素target - x
    需要注意的是没必要列举x元素的前面元素，因为在之前与x元素已经计算过了
    
  - 算法实现  

    ~~~java
    public static int[] twoSum3(int[] array, int num) {
        int[] return_array = {-1, -1};
        int len = array.length;
        int i = 0;
        while (i < len) {
            int target = num - array[i];
            for (int j = i + 1; j < len; j++) {
                if (target == array[j]) {
                    return_array[0] = i;
                    return_array[1] = j;
                    return return_array;
                }
            }
            i++;
        }
        return return_array;
    }
    ~~~

  - 算法复杂度分析

    - 时间复杂度   O(n^2)    最坏的情况下任意2个数字都要匹配一次
    - 空间复杂度   O(1)        

- 哈希表
  - 算法描述（空间换时间）
    
    1. 遍历一遍，将所有元素与下标+1存放在一个hashmap中，原因是不重复选择此数字
    2. 再遍历一遍数组，判断target -x是否存在hashmap中，如果存在则就是答案，否则返回不存在
    
  - 算法实现  
     ```java
    public static int[] twoSum2(int[] nums, int target) {
        int[] array = {-1, -1};
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i + 1);
        }
        for (int num : nums) {
          if (map.containsKey(target - num)) {
            array[0] = num;
            array[1] = target - num;
            break;
          }
        }
        return array;
    }
    ```
    
  - 时间复杂度
  
     - 时间复杂度      O(n)    存在N个数字，那么每个数字的查找时间为O(1)
  
     - 空间复杂度      O(n)    存在N个数字，那么hash表的存储为 N
  
- 总结

  - 第一种方式为冒泡式的匹配模式
  - 第二种方式为空间换时间的策略