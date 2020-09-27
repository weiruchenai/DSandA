package com.dataStuctureAndAlgorithm.LeetCode.DynamicProgramming;

/*
*   96. 不同的二叉搜索树
*       给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
*
*   思路： 1、状态：dp[i]表示i个节点共能组成的二叉树种数
*         2、选择：选择什么为根节点
*         3、base case：dp[0]=1,dp[1]=1，dp[2]=2
*         4、分析，i个节点时：以1为根节点，左边无节点，则右边有i-1个节点，共有dp[0]dp[i-1]
*                          以2为根节点，左边1个节点，右边i-2个节点，共有dp[1]dp[i-2]
*                       ...以n为根节点，左边n-1个节点，后面0个节点，共有dp[i-1]dp[0]
*         5、状态转移方程：dp[i] = dp[0]dp[i-1]+dp[1]dp[i-2]+...+dp[i-2]dp[1]+d[i-1]dp[0]
* */
public class DifferentBST_96 {
	public int numTrees(int n) {
		if(n < 2) return 1;
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		DifferentBST_96 d = new DifferentBST_96();
		System.out.println(d.numTrees(3));
	}
}
