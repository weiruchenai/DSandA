package com.dataStuctureAndAlgorithm.LeetCode.DynamicProgramming;

/*
*   309. 最佳买卖股票时机含冷冻期
*       问题相同：求最大利润
*       不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
*       卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
*
*   思路： 同122, 只需要将冷冻期的约束加入到状态转移方程中
*       1、dp[i][0]表示第i天不持有股票时的最大利润，dp[i][1]表示第i天持有股票时的最大利润
*       2、状态转移方程：
*          dp[i][0] = Max(dp[i-1][0], dp[i-1][1] + prices[i])
*          dp[i][1] = Max(dp[i-1][1], dp[i-2][0] - prices[i])
*          后者表示，当前持有股票分为两种情况，前一天也持有，或两天前未持有当前买入
* */
public class StockMaxProfit3_309 {
	public int maxProfit(int[] prices) {
		if(prices.length < 1) return 0;
		int[][] dp = new int[prices.length][2];
		dp[0][0] = 0;
		dp[0][1] = -prices[0];
		for (int i = 1; i < prices.length; i++) {
			if(i - 2 < 0) {
				dp[i][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
				dp[i][1] = Math.max(dp[0][1], dp[0][0] - prices[1]);
			}
			else {
				dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
				dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
			}
		}
		return dp[prices.length - 1][0];
	}
	
	//至于之前的3个状态相关，因此可以优化空间复杂度
	public int maxProfit2(int[] prices) {
		if(prices.length < 1) return 0;
		int dp_i_0 = 0, dp_i_1 = -prices[0], dp_pre_0 = 0;
		for (int i = 1; i < prices.length; i++) {
			//记录前一天的值
			int temp = dp_i_0;
			//更新后一天的值
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
			//此时前一天的值变成了两天前的值
			dp_pre_0 = temp;
		}
		return dp_i_0;
	}
}
