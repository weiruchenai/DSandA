package com.dataStuctureAndAlgorithm.LeetCode.DynamicProgramming;

/*
*   70. 爬楼梯
*       假设你正在爬楼梯。需要 n 阶你才能到达楼顶。一次可以选1/2，问到楼顶共有多少中方法
*
* */
public class ClimbStairs_70 {
	public int climbStairs(int n) {
		if(n <= 0) return -1;
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		
		return dp[n];
	}
}
