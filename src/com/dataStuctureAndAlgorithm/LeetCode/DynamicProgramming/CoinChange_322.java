package com.dataStuctureAndAlgorithm.LeetCode.DynamicProgramming;

/*
*   322. 零钱兑换
*       给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。
* */
public class CoinChange_322 {
	public int coinChange(int[] coins, int amount) {
/*		if(amount == 0) return 0;
		if(amount < 0 ) return -1;
		//dp[i] = x 代表当amount为i时最少需要x枚硬币
		int[] dp = new int[amount + 1];
		for(int i = 0; i <= amount; i ++){
			dp[i] = Integer.MAX_VALUE;
		}
		//base case初始化
		dp[0] = 0;
		
		for (int i = 0; i < dp.length; i++) {
			for (int coin : coins) {
				if(i - coin < 0) continue;
				dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
			}
		}
		
		return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];*/
			int[] dp = new int[amount + 1];
			for(int i = 1; i < amount + 1; i++){
				dp[i] = amount + 1;
			}
			dp[0] = 0;
			
			for(int i = 1; i < amount + 1; i++){
				//coins有几个元素，就有几种选择，减去这几个元素后的，最小值即可
				for(int coin : coins){
					//若i - coin < 0说明无解，跳过当前coin直接进入下一个coin
					if(i - coin < 0) continue;
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
			}
			
			return dp[amount] == amount + 1 ? -1 : dp[amount];
	
	
	
	
	
	
	
/*		if(amount == 0) return 0;
		if(amount < 0) return -1;
		
		//dp[i] = x,代表amount为i时，最少需要x枚硬币
		int[] dp = new int[amount + 1];
		for (int i = 0; i <= amount; i++) {
			dp[i] = amount + 1; //后面要求最小值,因此初始化为amount + 1(最多只能是amount)， 这里表示无穷大
		}
		dp[0] = 0;
		for (int i = 0; i < dp.length; i++) {
			for (int coin : coins) {
				//如果amount为i时，减去coin为负，说明无解，continue，直接换到下一个coin
				if(i - coin < 0) continue;
				dp[i] = Math.min(dp[i], 1 +  dp[i - coin]);
			}
		}
		return (dp[amount] == amount + 1) ? -1 : dp[amount];*/
	}
	
	public static void main(String[] args) {
		CoinChange_322 c = new CoinChange_322();
		int[] coins = {2};
		System.out.println(c.coinChange(coins, 3));
	}
}
