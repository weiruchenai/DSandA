package com.dataStuctureAndAlgorithm.LeetCode.DynamicProgramming;

/*
*   5.最长回文字符串
*       给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000
*
*   思路：找出所有回文字符串，从中选取i-j+1最大的值即可
*        1、状态dp[i][j]=True or False，代表以s_i和s_j下标的子串是否是回文字符串
*        2、base case: dp[i][i]=1, dp[i][i+1] = s_i == s_j
*        3、dp[i][j]=b[i+1][j-1] && (s_i==s_j)
*
* */
public class LongestPalindrome_5 {
	public String longestPalindrome(String s) {
		if(s.length() < 2) return s;
		StringBuilder sb = new StringBuilder(s);
		boolean[][] dp = new boolean[sb.length()][sb.length()];
		for (int i = 0; i < sb.length(); i++) {
			dp[i][i] = true;
			if(i < sb.length() - 1)  dp[i][i + 1] = sb.charAt(i) == sb.charAt(i + 1);
		}
		
		for (int j = 1; j < sb.length(); j++) {
			for (int i = 0; i < j - 1; i++) {
				 dp[i][j] = dp[i + 1][j -1] && (sb.charAt(i) == sb.charAt(j));
			}
		}
		
		int[] index = getLongestIndex(dp);
		return sb.substring(index[0], index[1] + 1);
	}
	
	public int[] getLongestIndex(boolean[][] dp){
		int[] index = new int[2];
		int pre = 0;
		//遍历dp数组，从中找出i - j + 1最大的那组i,j。
		for (int i = 0; i < dp.length; i++) {
			for (int j = i; j < dp.length; j++) {
				if(dp[i][j] && pre < j - i + 1){
					pre = j - i + 1;
					index[0] = i;
					index[1] = j;
				}
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		LongestPalindrome_5 l = new LongestPalindrome_5();
		String s = "bbb";
		System.out.println(l.longestPalindrome(s));
	}
}
