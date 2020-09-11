package com.dataStuctureAndAlgorithm.LeetCode.DynamicProgramming;

/*
*   392. 判断子序列
*       给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
*       你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
*       字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
*       （例如，"ace"是"abcde"的一个子序列，而"aec"不是
*
*   思路：1、双指针：对于s 和 t各分配一个指针
*        2、对于若s[i] == t[j]则匹配到，那么ij都移一位
*        3、若s[i] != t[j]则未匹配到，i不懂，j向后移一位(到t中剩余的字符串中去查找)
*        4、若i移到了s的末尾(i=s.length+1)，代表i中所有元素都在j中匹配到，返回true
* */
public class SubSequence_392 {
	public boolean isSubsequence(String s, String t) {
		int sLength = s.length(), tLength = t.length();
		int i = 0, j= 0;
		while (i < sLength && j < tLength){
			if(s.charAt(i) == t.charAt(j)){
				i++;
			}
			j++;
		}
		return i == sLength;
	}
	
	public static void main(String[] args) {
		SubSequence_392 sub = new SubSequence_392();
		String s = "leeeeetcode", t = "sss";
		System.out.println(t.indexOf('l'));
		System.out.println(sub.isSubsequence(s, t));
	}
}
