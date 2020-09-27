package com.dataStuctureAndAlgorithm.LeetCode.DynamicProgramming;

import java.util.Arrays;

/*
*   279. 完全平方数
*    给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
*
*   思路： 1、状态:dp[i]表示对于正整数i，其完全平方数个数最小为个数
*         2、选择：根号(i)向下取整，从1到该证书
*         3、状态转移方程：dp[i] = Min(dp(i-x^2) + 1, x=(1,...,int sqrt(i)))
* */
public class AbsoluteNumSquare_279 {
	public int numSquares(int n) {
		if(n == 1) return 1;
		int[] dp = new int[n + 1];
		//初始化dp数组为最大值，其最大的完全平方数个数为n个1，
		Arrays.fill(dp, n);
		dp[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			//若能被开方，则dp[i] = 1
			if(Math.sqrt(i) % 1 == 0) dp[i] = 1;
			else {
				for (int j = 1; j <= (int) Math.sqrt(i); j++) {
					dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
				}
			}
		}
		return dp[n];
	}
}
