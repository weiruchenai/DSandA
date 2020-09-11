package com.dataStuctureAndAlgorithm.LeetCode.DynamicProgramming;

/*
*   746. 使用最小花费爬楼梯
*       数组的每个索引作为一个阶梯，第i个阶梯对应着一个非负数的体力花费值cost[i](索引从0开始)。
*       每当你爬过一个阶梯你都要花费该阶梯对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
*       您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
*
* */
public class MinCostClimbingStairs_746 {
	public int minCostClimbingStairs(int[] cost) {
		int[] dp = new int[cost.length + 1];
		dp[0] = 0;
		dp[1] = 0;
		dp[2] = Math.min(cost[0], cost[1]);
		
		for (int i = 3; i < dp.length; i++) {
			dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
		}
		return dp[cost.length];
	}
	
	public static void main(String[] args) {
		MinCostClimbingStairs_746 m = new MinCostClimbingStairs_746();
		int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		System.out.println(m.minCostClimbingStairs(cost));
	}
}
