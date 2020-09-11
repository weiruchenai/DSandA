package com.dataStuctureAndAlgorithm.LeetCode.DynamicProgramming;
/*
*   面试题 08.01. 三步问题
*       三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。
*       结果可能很大，你需要对结果模1000000007
*
*   思路： 1、状态：dp[i]=x代表走i个台阶有x种方法
*         2、选择：下一步可以选择走1、2、3个台阶
*         4、base case: dp[1]=1,dp[2]=2,dp[3]=4
*         5、dp[i] = dp[i-1]+dp[i-1]+dp[i-3]
* */
public class WayToStep_0801 {
	public int waysToStep(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		if(n == 2) return 2;
		if(n == 3) return 4;
		
		long[] dp = new long[n + 1];
		dp[1]=1; dp[2]=2; dp[3] = 4;
		
		for (int i = 4; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i -3];
			dp[i] %= 1000000007;
		}
		return (int) dp[n];
	}
}
