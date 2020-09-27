package com.dataStuctureAndAlgorithm.LeetCode.DynamicProgramming;

/*
*   213. 打家劫舍 II
*       不能偷相邻两栋房子，这里房子围成一个圈，即不能同时偷开始和结束的两栋房，求偷到的最大金额
*
*   思路： 1、状态：dp[i]代表从i栋房开始偷的最大金额
*         2、选择：对于当前房子，可以选择偷或者不偷
*         3、base case：若从最后一栋房开始偷，则dp[i]=nums[i]
*         4、状态转移方程：dp[i]=Max(dp[i+1], nums[i] + dp[i+2])，即当前不偷和当前偷中选较大的那个
*         4、思考，因为不能同时偷首尾，因此分两种情况，偷1不偷N，或偷N不偷1。
*
* */
public class Rob_2_213 {
	public int rob(int[] nums) {
		int n = nums.length;
		if(nums.length == 1) return nums[0];
		//偷1与不偷1，从中选取较大的那个值
		int x = rob(nums, 0, n - 2);
		return Math.max(rob(nums, 0, n-2),
				rob(nums, 1, n - 1));
	}
	
	public int rob(int[] nums, int start, int end){
		int n = nums.length;
		int[] dp = new int[n + 2];
		dp[n] = 0;
		for (int i = end; i >= start; i--) {
			dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
		}
		
		int max = 0;
		for (int i : dp) {
			if(i > max) max = i;
		}
		return max;
	}
	
	public static void main(String[] args) {
		Rob_2_213 r = new Rob_2_213();
		int[] nums = {2, 3, 2};
		System.out.println(r.rob(nums));
	}
}
