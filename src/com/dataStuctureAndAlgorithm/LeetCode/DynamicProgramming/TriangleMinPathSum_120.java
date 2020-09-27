package com.dataStuctureAndAlgorithm.LeetCode.DynamicProgramming;

import java.util.List;

/*
*       120. 三角形最小路径和
*           给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
*           相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
*
*       思路：1、状态dp[i][j]=x 代表到达triangle节点[i][j]的最小路径和(i为层数，j为下标数)
*            2、选择，选下一层相同下标，或下一层+1的下标
*            3、base case dp[0][0]=
 */
public class TriangleMinPathSum_120 {
	public int minimumTotal(List<List<Integer>> triangle) {
		if(triangle.size() < 2) return triangle.get(0).get(0);
		
		//行长为三角形层数，列宽为三角形最底层的长度
		int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
		dp[0][0] = triangle.get(0).get(0);
		
		//外层最大为总行数，内层最大为三角形该行的长度
		for (int i = 1; i < triangle.size(); i++) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				if(j == 0) {
					//j 在三角形左边的边上，则=上一行的第一个值 + 当前值
					dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
				}else if(j == triangle.get(i).size() - 1) {
					//j 在三角形另一边，则=上一行最后一个元素值 + 当前值
					dp[i][j] = dp[i - 1][triangle.get(i - 1).size() - 1] + triangle.get(i).get(j);
				}else {
					dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
				}
			}
		}
		
		//遍历dp的最后一层，找出最小的那个
		int min = Integer.MAX_VALUE;
		for (int i : dp[triangle.size() - 1]) {
			min = Math.min(min, i);
		}
		return min;
	}
}
