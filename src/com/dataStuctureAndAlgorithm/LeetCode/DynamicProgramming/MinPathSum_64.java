package com.dataStuctureAndAlgorithm.LeetCode.DynamicProgramming;

/*
*   64. 最小路径和
*       给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。每次只能向下或者向右移动一步。
*
*   思路：1、状态:dp[i][j]=x 代表到到grid[i][j]的最小路径和为x
*        2、选择；向右或向下
*        3、base case：i = j = 0,时，dp[i][j]=grid[0][0]
*        4、状态转移方程：dp[i][j] = Min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
*
* */
public class MinPathSum_64 {
	public int minPathSum(int[][] grid) {
		int[][] dp = new int[grid.length][grid[0].length];
		dp[0][0] = grid[0][0];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(i == 0 && j > 0) dp[i][j] = dp[i][j - 1] + grid[i][j];
				if(j == 0 && i > 0) dp[i][j] = dp[i - 1][j] + grid[i][j];
				if(i > 0 && j > 0){
					dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
				}
			}
		}
		return dp[grid.length - 1][grid[0].length - 1];
	}
	
	public static void main(String[] args) {
		MinPathSum_64 m = new MinPathSum_64();
		int[][] grid={{1,2},{1,1}};
		System.out.println(m.minPathSum(grid));
	}
}
