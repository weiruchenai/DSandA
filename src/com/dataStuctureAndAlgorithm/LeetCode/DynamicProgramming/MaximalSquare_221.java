package com.dataStuctureAndAlgorithm.LeetCode.DynamicProgramming;

/*
*   221. 最大正方形
*        在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
*
*   思路：1、状态：dp[i][j]表示以nums[i][j]为正方形右下角的最大正方形长为x
*        2、base case: dp[0][j] = nums[0][j] == 1 ? 1 : 0, dp[i][0] = nums[i][0] == 1 ? 1 : 0;
*        3、状态转移方程
*           若nums[i][j]=1， dp[i][j]=1 + Min(Min(dp[i-1][j],dp[i][j-1]), dp[i-1[j-1])
*           若nums[i][j]=0, dp[i][j]=0
*
* */
public class MaximalSquare_221 {
	public int maximalSquare(char[][] matrix) {
		if(matrix.length == 0) return 0;
		int[][] dp = new int[matrix.length][matrix[0].length];
		//定义一个maxEdge记录最长边，最后返回maxEdge^2
		int maxEdge = 0;
		//base case 初始化，长 和 宽
		for (int i = 0; i < matrix[0].length; i++) {
			dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
			if(dp[0][i] == 1) maxEdge = 1;
		}
		for (int i = 0; i < matrix.length; i++) {
			dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
			if(dp[i][0] == 1) maxEdge = 1;
		}
		
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if(matrix[i][j] == '0') dp[i][j] = 0;
				else {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
					maxEdge = Math.max(dp[i][j], maxEdge);
				}
			}
		}
		return maxEdge * maxEdge;
	}
}
