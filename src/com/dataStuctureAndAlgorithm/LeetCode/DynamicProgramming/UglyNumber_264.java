package com.dataStuctureAndAlgorithm.LeetCode.DynamicProgramming;

/*
*   264. 丑数 II
*       丑数就是质因数只包含 2, 3, 5 的正整数。
*       找出第n个丑数
*
* */
public class UglyNumber_264 {
	public int nthUglyNumber(int n) {
		if(n == 1) return 1;
		int[] dp = new int[1691];
		dp[1] = 1;
		int ugly, i2 = 1, i3 = 1, i5 = 1;
		for (int i = 2; i < 1691; i++) {
			ugly = Math.min(Math.min(dp[i2] * 2, dp[i3] *3), dp[i5] * 5);
			dp[i] = ugly;
			if(ugly == dp[i2] * 2) i2++;
			if(ugly == dp[i3] * 3) i3++;
			if(ugly == dp[i5] * 5) i5++;
		}
		
		return dp[n];
	}
	
	public static void main(String[] args) {
		UglyNumber_264 u = new UglyNumber_264();
		System.out.println(u.nthUglyNumber(15));
	}
}
