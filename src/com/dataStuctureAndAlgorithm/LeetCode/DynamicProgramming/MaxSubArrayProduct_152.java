package com.dataStuctureAndAlgorithm.LeetCode.DynamicProgramming;

/*
*   152. 乘积最大子数组
*         给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
*
*   思路：1、若按照最大子数组和，dp[i]表示以num[i]结尾的最大和，dp[i]=Max(dp[i-1]+num[i], num[i])，则会有问题
*           例如[-2, 2, -3]的真实结果为12，但输出为2.因为dp[i]不仅仅决定与dp[i-1]。
*        2、定义两个dp数组，maxs[i],mins[i]分别表示以nums[i]结尾的最大乘积和最小乘积。
*        3、base case： maxs[0]=mins[0]=nums[0]
*        4、选择：可以分情况，nums[i]>=0和nums[i]<0
*        5、状态转移方程
*               若nums[i]>0,maxs[i]=Max(maxs[i-1]*nums[i], nums[i]),
*                           mins[s]=Min(mins[i-1]*nums[i], nums[i])
*               若nums[i]<0,maxs[i]=Max(mins[i-1]*nums[i], nums[i]),
*                           mins[i]=Min(maxs[i-1]*nums[i], nums[i])
* */
public class MaxSubArrayProduct_152 {
	public int maxProduct(int[] nums) {
		if (nums.length == 0) return 0;
		int[] maxs = new int[nums.length];
		int[] mins = new int[nums.length];
		maxs[0] = nums[0];
		mins[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if(nums[i] >= 0) {
				maxs[i] = Math.max(maxs[i - 1] * nums[i], nums[i]);
				mins[i] = Math.min(mins[i - 1] * nums[i], nums[i]);
			}else {
				maxs[i] = Math.max(mins[i - 1] * nums[i], nums[i]);
				mins[i] = Math.min(maxs[i - 1] * nums[i], nums[i]);
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int i : maxs) {
			if(i > max) max = i;
		}
		return max;
	}
	
	public static void main(String[] args) {
		MaxSubArrayProduct_152 m = new MaxSubArrayProduct_152();
		int[] nums = {2,-5,-2,-4,3};
		System.out.println(m.maxProduct(nums));
	}
}
