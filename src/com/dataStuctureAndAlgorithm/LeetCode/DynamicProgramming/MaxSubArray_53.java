package com.dataStuctureAndAlgorithm.LeetCode.DynamicProgramming;

import java.util.Arrays;

/*
*   53. 最大子序和
*       给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
*
*   思路：1、找状态:dp[i] = x表示以num[i]为结尾的maxSubArray为x
*        2、base case:dp[0]表示最大子序列以nums[0]结尾，此时前面没有元素，故dp[0] = nums[0]
*        3、选择：在已知dp[i - 1]下，有两个选择
*           （1）num[i] < 0, 故num[i]单个元素自身为dp[i]
*           （2）nums[i] >= 0，num[i]与dp[i-1]结合，新的和为最大和
*            总而言之，求这两个选择中的最大值即可。
*
* */
public class MaxSubArray_53 {
	public int maxSubArray(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
/*			if(dp[i - 1] < 0) dp[i] = nums[i];
			if(dp[i - 1] >= 0) dp[i] = dp[i - 1] + nums[i];*/
		}
		
		System.out.println(Arrays.toString(dp));
		return getMax(dp);
	}
	
	public int getMax(int[] dp){
		int max = Integer.MIN_VALUE;
		for (int j : dp) {
			if (j > max) max = j;
		}
		return max;
	}
	
	public static void main(String[] args) {
		MaxSubArray_53 maxSubArray_53 = new MaxSubArray_53();
		int[] nums = {1,2,-1,-2,2,1,-2,1,4,-5,4};
		System.out.println(maxSubArray_53.maxSubArray(nums));
	}
	
}
