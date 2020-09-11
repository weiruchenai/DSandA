package com.dataStuctureAndAlgorithm.LeetCode.DynamicProgramming;
/*
*   303. 区域和检索 - 数组不可变
*       给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
*       可以假设数组不可变。会多次调用 sumRange 方法。
*
*   思路：1、dp[i] = x表示0-i索引的所有数据和
*        3、那么所求和即为dp[j] - dp[i - 1]
* */
public class SumRange_303 {
	int[] dp;
 	public SumRange_303(int[] nums) {
 		if(nums.length == 0) return;
		dp = new int[nums.length];
 		dp[0] = nums[0];
	    for (int i = 1; i < nums.length; i++) {
		    dp[i] = dp[i - 1] + nums[i];
	    }
	}
	
	public int sumRange(int i, int j) {
 		if(i == 0) return dp[j];
		return dp[j] - dp[i - 1];
	}
}
