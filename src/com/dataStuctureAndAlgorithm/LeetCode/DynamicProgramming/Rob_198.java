package com.dataStuctureAndAlgorithm.LeetCode.DynamicProgramming;

/*
*   198. 打家劫舍
*       你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
*       如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
*       给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
*
*   思路：1、状态：dp[i] = x表示最后偷的一家为nums[i]时，最大金额为x
*        2、base case：i = 0时，前面没有房屋可偷，dp[0] = nums[0]
*                     i = 1时，偷两间房屋中较大的一件房，dp[1] = max(nums[0], nums[1])
*        3、选择：对于dp[i]，则等于num[i] + max(dp[i - 2],...,dp[0])
* */
public class Rob_198 {
	public int rob(int[] nums) {
		if(nums.length == 1) return nums[0];
		if(nums.length == 2) return Math.max(nums[0], nums[1]);
		
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			int max = 0;
			for (int j = 0; j < i - 1; j++) {
				max = Math.max(dp[j], max);
			}
			dp[i] = max + nums[i];
		}
		
		int max = Integer.MIN_VALUE;
		for (int i : dp) {
			if(i > max) max = i;
		}
		return max;
	}
	
	public static void main(String[] args) {
		Rob_198 rob_198 = new Rob_198();
		int[] nums = {1,2,3,1,6,8};
		System.out.println(rob_198.rob(nums));
	}
}
