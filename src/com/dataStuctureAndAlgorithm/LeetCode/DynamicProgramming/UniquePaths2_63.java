package com.dataStuctureAndAlgorithm.LeetCode.DynamicProgramming;

/*
*   63. 不同路径 II
*      现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
*      输入的是一个二维数组，1和0代表该处伪障碍或空
*
*
* */
public class UniquePaths2_63 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
		if(obstacleGrid[0][0] == 1) return 0;
		dp[0][0] = 1;
		//i = 0 时初始化第一列，在遇到第一个1前都只有1中走法，后面都为0
		for (int i = 1; i < obstacleGrid[0].length; i++) {
			if(obstacleGrid[0][i] == 1) dp[0][i] = 0;
			else dp[0][i] = dp[0][i - 1];
		}
		//j = 0时初始化第一排， 在遇到第一个1前都只有1中走法，后面都为0
		for (int i = 1; i < obstacleGrid.length; i++) {
			if(obstacleGrid[i][0] == 1) dp[i][0] = 0;
			else dp[i][0] = dp[i - 1][0];
		}
		
		for (int i = 1; i < obstacleGrid.length; i++) {
			for (int j = 1; j < obstacleGrid[0].length; j++) {
				//若当前为1,则当前点无法到达
				if(obstacleGrid[i][j] == 1){
					dp[i][j] = 0;
				}else{
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
	}
	
	public static void main(String[] args) {
		UniquePaths2_63 u2 = new UniquePaths2_63();
		int[][] obstacleGrid = {{0, 1, 0}, {0, 0, 0}, {0, 0, 0}};
		System.out.println(u2.uniquePathsWithObstacles(obstacleGrid));
	}
}
