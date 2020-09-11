package com.dataStuctureAndAlgorithm.LeetCode.DynamicProgramming;
/*
*   121. 买卖股票的最佳时机
*       给定一个数组，它的第i 个元素是一支给定股票第 i 天的价格。
*       如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
*
*   思路：1、状态：dp[i] = x表示第i天卖出时，最高利润为x
*        2、选择：已知i-1天卖出的最高利润dp[i-1]，
*              (1).dp[i-1]+p[i]-p[i-1]若大于0,则等于当前第i天卖出最大利润dp[i]
*              (2).若小于0，当前第i天卖出的最大利润dp[i]为0
*        3、base case： 不存在第0天卖出的情况，因此dp[1]=max(0, p[1]-p[0])
*
* */
public class StockMaxProfit_121 {
	public int maxProfit(int[] prices) {
		if(prices.length < 2) return 0;
		int n = prices.length;
		int[] dp = new int[n];
		dp[1] = Math.max(0, prices[1] - prices[0]);
		for (int i = 2; i < n; i++) {
			dp[i] = Math.max(0, dp[i - 1] + prices[i] - prices[i - 1]);
		}
		
		int max = 0;
		for (int i : dp) {
			max = Math.max(max, i);
		}
		return max;
 	}
	
	public static void main(String[] args) {
		StockMaxProfit_121 s = new StockMaxProfit_121();
		//int[] prices = {7,6,4,5,1};
		int[] prices = {7,1,6,3,6,4};
		System.out.println(s.maxProfit(prices));
	}
}
