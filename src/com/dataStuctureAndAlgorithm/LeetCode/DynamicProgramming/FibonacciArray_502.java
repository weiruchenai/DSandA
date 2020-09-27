package com.dataStuctureAndAlgorithm.LeetCode.DynamicProgramming;

/*
*   509. 斐波那契数，斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和
* */
public class FibonacciArray_502 {
	//递归法，因为存在过多的重叠子问题，所以效率低
	public int fib(int N) {
		if(N == 1 || N == 2) return 1;
		return fib(N - 1) + fib(N - 2);
	}
	
	//动态规划，自底向上
/*	public int fib1(int N) {
		if(N == 0) return 0;
		if(N == 1 || N == 2) return 1;
		int[] dp = new int[N + 1];
		dp[1] = 1;
		dp[2] = 1;
		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[N];
	}*/
	
	public int fib1(int n) {
		if(n == 0) return 0;
		if(n == 1 || n == 2) return 1;
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 1;
		for (int i = 3; i < n + 1; i++) {
			dp[i] = dp[i -1] + dp[i - 2];
		}
		return dp[n];
	}
	
	public int function(int n){
		if(n == -1) return 1;
		return n == 0 ? 0 : n + function(n-1);
	}
	
	public static void main(String[] args) {
		FibonacciArray_502 f = new FibonacciArray_502();
		System.out.println(f.function(3));
	}
}
