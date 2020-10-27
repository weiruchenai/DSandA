package com.dataStuctureAndAlgorithm.LeetCode.DynamicProgramming;

import java.util.Arrays;

/*
*   300. 最长上升子序列
*       给定一个无序的整数数组，找到其中最长上升子序列的长度。
*
*   思路：1、状态：dp[i]=x表示以nums[i]元素结尾的最常递增子序列长度为x
*        2、base case：dp[0]=1
*        3、选择：对于dp[i + 1]，可以选择以左边所有元素结尾，其中最长的一个长度 + 1
* */
public class LengthOfLIS_300 {
	public int lengthOfLIS(int[] nums) {
		if(nums.length == 0) return 0;
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		
		for (int i = 1; i < nums.length; i++) {
			for (int j = i - 1; j >= 0 ; j--) {
				if(nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
		int max = 0;
		for (int i : dp) {
			if(i > max) max = i;
		}
		return max;
	}
	
	public static void main(String[] args) {
		LengthOfLIS_300 l = new LengthOfLIS_300();
		int[] nums = {1,3,6,7,9,4,10,5,6};
		System.out.println(l.lengthOfLIS(nums));
	}
}
