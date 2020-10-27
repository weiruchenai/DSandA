package com.dataStuctureAndAlgorithm.LeetCode.DynamicProgramming;

/*
*   357. 计算各个位数不同的数字个数
*       给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10^n 。
*       要求是任意两位都不能相同，如101也因去除
*
*   思路：1、令dp[n]表示10^n内的相同数的个数
*        2、base case: dp[1]=0, dp[2]=91,
*        3、状态转移方程：dp[i] = dp[i - 1] + i位数中的相同个数
*        4、i位数的相同个数计算：2个相同、3个相同、...、i个相同
*
* */
public class CountNumsWithUniqueDigits_357 {
	public int countNumbersWithUniqueDigits(int n) {
		//各位数字都不同。
		//来详解一下
		//dp[i]=dp[i-1]+(dp[i-1]-dp[i-2])*(10-(i-1));
		//加上dp[i-1]没什么可说的，加上之前的数字
		//dp[i-1]-dp[i-2]的意思是我们上一次较上上一次多出来的各位不重复的数字。以n=3为例，n=2已经计算了0-99之间不重复的数字了，我们需要判断的是100-999之间不重复的数字，那也就只能用10-99之间的不重复的数去组成三位数，而不能使用0-9之间的不重复的数，因为他们也组成不了3位数。而10-99之间不重复的数等于dp[2]-dp[1]。
		//当i=2时，说明之前选取的数字只有
		//1位，那么我们只要与这一位不重复即可，所以其实有9(10-1)种情况（比如1，后面可以跟0,2,3,4,5,6,7,8,9）。
		//当i=3时，说明之前选取的数字有2位，那么我们需要与2位不重复，所以剩余的
		//有8（10-2）种（比如12，后面可以跟0,3,4,5,6,7,8,9）
		if(n==0)
			return 1;
		int []dp=new int [n+1];
		dp[0]=1;
		dp[1]=10;
		for(int i=2;i<=n;i++)
		{
			dp[i]=dp[i-1]+(dp[i-1]-dp[i-2])*(10-(i-1));
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		CountNumsWithUniqueDigits_357 c = new CountNumsWithUniqueDigits_357();
		System.out.println((int) Math.pow(10, 2));
		System.out.println(c.countNumbersWithUniqueDigits(3));
	}
}
