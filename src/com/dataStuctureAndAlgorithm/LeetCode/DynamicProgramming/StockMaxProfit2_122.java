package com.dataStuctureAndAlgorithm.LeetCode.DynamicProgramming;

/*
*   122. 买卖股票的最佳时机 II
*       给定一个数组，它的第i个元素是一支给定股票第i天的价格。
*       设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
*       注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
*
*   思路：
*       1、状态：dp[i][j]，其中i表示日期，j表示当前第i天是否持有股票，只有两种状态0和1，1代表持有，0代表不持有
*               dp[i][1]就表示第i天手上持有股票，目前的最大利润，dp[i][0]表示第i天手上没有股票，目前的最大利润
*       2、状态转移方程: 对于每一天都有持有或不持有两种状态
*               当前不持有有两种情况：前一天不持有，或前一天持有当天卖出（加上当天的价格）
*                   dp[i][0] = Max(dp[i-1][0], dp[i-1][1] + prices[i])
*               当前持有也分两种情况：前一天不持有当天买入（减去当天价格），或前一天也持有
*                   dp[i][1] = Max(dp[i-1][1], dp[i-1][0] - prices[i])
*       3、最终返回的是dp[n-1][0]，表示最后一天不持有状态时，能够获取的最大利润
*       4、base case：dp[0][0] = 0, dp[0][1]=-price[0](即买了股票，尚未卖出，利润为0-买股票的钱)
*
* */
public class StockMaxProfit2_122 {
	public int maxProfit(int[] prices) {
		if(prices.length < 1) return 0;
		int[][] dp = new int[prices.length][2];
		dp[0][0] = 0;
		dp[0][1] = -prices[0];
		for (int i = 1; i < prices.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
			dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
		}
		return dp[prices.length - 1][0];
	}
	
	//其实第i天的两个状态都只与前一天相关，因此可以进行优化,来降低空间复杂度
	public int maxProfit2(int[] prices) {
		if(prices.length < 1) return 0;
		int dp_i_0 = 0, dp_i_1 = -prices[0];
		for (int i = 1; i < prices.length; i++) {
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_0 - prices[i], dp_i_1);
		}
		return dp_i_0;
	}
}
