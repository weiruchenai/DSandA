package com.dataStuctureAndAlgorithm.LeetCode.DynamicProgramming;

/*
*   343. 整数拆分
*       给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
*
*   思路：1、从2开始，依次列出2-10的拆分结果，就能找到规律
*        2、另dp[i]为数i的拆分后的最大乘积
*        3、那么if(dp[i-1] / 4 为整数)，dp[i] = dp[i-1]/4 * 6
*               else if(dp[i-1]/2为整数) dp[i] = dp[i-1]/2 *3
*               else dp[i] = dp[i-1]/3 * 4 (这种情况拆分结果全为3)
* */
public class IntegerBreak_343 {
	public int integerBreak(int n) {
		if(n < 2 || n > 58) return -1;
		double[] dp = new double[n + 1];
		dp[2] = 1;
		dp[3] = 2;
		dp[4] = 4;
		for (int i = 5; i <= n; i++) {
			if((dp[i - 1] / 4) % 1 == 0)
				dp[i] = dp[i - 1] / 4 * 6;
			else if((dp[i - 1] / 4) % 1 != 0 && (dp[i -1] / 2) % 1 == 0)
				dp[i] = dp[i - 1] / 2 * 3;
			else
				dp[i] = dp[i - 1] / 3 * 4;
		}
		return (int) dp[n];
	}
	
	public static void main(String[] args) {
		
		System.out.println((4 / 4) % 1 == 0);
		System.out.println(new IntegerBreak_343().integerBreak(14));
	}
}
