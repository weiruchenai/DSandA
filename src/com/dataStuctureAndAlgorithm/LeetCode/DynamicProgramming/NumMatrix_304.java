package com.dataStuctureAndAlgorithm.LeetCode.DynamicProgramming;

import java.util.Arrays;

/*
*   304. 二维区域和检索 - 矩阵不可变
*       给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
*
*   思路： 1、在构造函数中，计算dp[i][j]，代表从0,0到i,j的矩形中的所有元素和。
*              dp[i][j] = dp[i-1][j]+dp[i][i-1]-dp[i-1][j-1] + matrix[i][j]
*         2、在方法中，根据dp[i][j]来提取面积。(存在边界问题，因此bp[][]的长宽都比nums矩阵大一个，dp[1][1]代表num[0][0])
*              因此 dp[i][j] = dp[i-1][j]+dp[i][i-1]-dp[i-1][j-1] + matrix[i - 1][j - 1]
*         3、S = dp[r2+1,c2+1]-dp[r1,c2+1]-dp[r2+1,c1]+dp[r1,c1],其中最后一项为减去的两项中重叠的部分面积。
*
* */
public class NumMatrix_304 {
	int[][] dp;
	public NumMatrix_304(int[][] matrix) {
		if(matrix.length == 0) return;
		dp = new int[matrix.length + 1][matrix[0].length + 1];
		dp[1][1] = matrix[0][0];
		for (int i = 1; i < matrix.length + 1; i++) {
			for (int j = 1; j < matrix[0].length + 1; j++) {
				//减去重叠部分后再加上当前元素格的值
				dp[i][j] = dp[i][j - 1] + dp[i - 1][j]
						- dp[i - 1][j - 1] + matrix[i - 1][j - 1];
			}
		}
	}
	
	public int sumRegion(int row1, int col1, int row2, int col2) {
		if(row2 == 0 && col2 == 0) return dp[1][1];
		return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1]
				- dp[row2 + 1][col1] + dp[row1][col1];
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2}};
		NumMatrix_304 n = new NumMatrix_304(matrix);
		System.out.println(Arrays.deepToString(n.dp));
	}
}
