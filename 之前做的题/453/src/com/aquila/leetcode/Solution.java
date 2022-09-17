package com.aquila.leetcode;

import java.util.Arrays;

/*
* 所有n-1个元素都加一，等同于只有一个元素减一
* 主要是不会使用Java中取最小值的函数用法
* Collections.min()可以获取最小值，但要求入参为List
*
* Arrays.asList()可以将入参数组转化为List对象，但要求入参必须是泛型数组，原题中给的是int[]，不是Integer[]
* --因为Integer泛型实现了比较大小的接口
*
* 官方解题答案给的解法是 Arrays.stream(nums).min().getAsInt();
* 通过stream转为Integer
*
* */
class Solution {
    public int minMoves(int[] nums) {
//        Arrays.stream(nums).min().getAsInt();
        int min = getMin(nums);
        int moveTimes = 0;
        for (int num : nums) {
            moveTimes += num - min;
        }
        return moveTimes;
    }

    int getMin(int[] nums) {
        int min = nums[0];
        for (int num : nums) {
            if (min > num) {
                min = num;
            }
        }
        return min;
    }
}

/*  官方题解

class Solution {
    public int minMoves(int[] nums) {
        int minNum = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for (int num : nums) {
            res += num - minNum;
        }
        return res;
    }
}

作者：LeetCode-Solution
        链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/solution/zui-xiao-cao-zuo-ci-shu-shi-shu-zu-yuan-3meg3/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
