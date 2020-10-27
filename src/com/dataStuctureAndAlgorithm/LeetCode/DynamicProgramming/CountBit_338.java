package com.dataStuctureAndAlgorithm.LeetCode.DynamicProgramming;

import java.util.Arrays;

/*
*       338. 比特位计数
*           给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
*       思路：1、状态dp[i]表示i的二进制包含的1的个数
*            2、
*
* */
public class CountBit_338 {
	public int[] countBits(int num) {
		int[] dp = new int[num + 1];
		for (int i = 0; i <= num; i++) {
			String binaryNum = Integer.toBinaryString(i);
			char[] binaryCharNums = binaryNum.toCharArray();
			int count = 0;
			for (char c : binaryCharNums) {
				if(c == '1') count++;
			}
			dp[i] = count;
		}
		return dp;
	}
	
	public static void main(String[] args) {
		CountBit_338 c = new CountBit_338();
		System.out.println(Arrays.toString(c.countBits(3)));
	}
}
