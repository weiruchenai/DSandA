package com.dataStuctureAndAlgorithm.LeetCode.DynamicProgramming;

/*
*   62. 不同路径
*       一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
*       机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
*       问总共有多少条不同的路径？]
*
*   思路：1、状态：dp[i][j]=x代表起点到(i,j)共有x条路径
*        2、选择：向下或向右
*        3、base case: dp[1][j]=1,dp[i][1]=1,也就是单行或单列，结果都为1
*        4、dp[i][j] = dp[i -1][j] + dp[i][j - 1]
*
* */
public class UniquePaths_62 {
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		dp[1][1] = 1;
		if(n >= 2){
			for (int i = 2; i < n + 1; i++) {
				dp[1][i] = 1;
			}
		}
		if(m >= 2) {
			for (int i = 2; i < m + 1; i++) {
				dp[i][1] = 1;
			}
		}
		
		for (int i = 2; i < m + 1; i++) {
			for (int j = 2; j < n + 1; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		
		return dp[m][n];
	}
	
	public static void main(String[] args) {
		UniquePaths_62 u = new UniquePaths_62();
		System.out.println(u.uniquePaths(7, 3));
	}
}
