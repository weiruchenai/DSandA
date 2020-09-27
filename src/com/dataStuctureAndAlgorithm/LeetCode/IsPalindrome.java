package com.dataStuctureAndAlgorithm.LeetCode;

/*
*      9. 回文数
*          判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
*
* */
public class IsPalindrome {
	public boolean isPalindrome(int x) {
		//负数直接false
		if(x < 0) return false;
		StringBuilder sb = new StringBuilder(Integer.toString(x));
		//对于正数而言，如果长度为1，则返回true
		return isPalindrome(sb);
		
	}
	
	public boolean isPalindrome(StringBuilder sb){
		if(sb.length() == 1) return true;
		//获取首尾，不相同则false，相同则删除首尾再传入方法递归
		char start = sb.charAt(0);
		char end = sb.charAt(sb.length() - 1);
		if(start != end) return false;
		sb.deleteCharAt(0);
		sb.deleteCharAt(sb.length() - 1);
		
		StringBuilder temp = sb.length() == 0 ? new StringBuilder("0") : sb;
		return isPalindrome(temp);
	}
	
	public static void main(String[] args) {
		IsPalindrome p = new IsPalindrome();
		System.out.println(p.isPalindrome(1000021));
	}
}
