package com.dataStuctureAndAlgorithm.LeetCode.Backtracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
*       17. 电话号码的字母组合
*           给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
*			给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
*           2abc,3def,4ghi,5jkl,6mno,7pqrs,8tuv,9wxyz
* */
public class LetterCombinations_17 {
	List<String> result = new LinkedList<>();
	HashMap<Character,String> map = new HashMap<>(){
		{
			put('2',"abc"); put('3',"def"); put('4',"ghi");
			put('5',"jkl"); put('6',"mno"); put('7',"pqrs");
			put('8',"tuv"); put('9',"wxyz");
		}
	};
	public List<String> letterCombinations(String digits) {
		if(digits.length()==0) return result;
		StringBuffer track = new StringBuffer();
		backtrack(0, digits, track);
		return result;
	}
	
	private void backtrack(int index, String digits, StringBuffer track) {
		if(track.length() == digits.length()){
			result.add(track.toString());
			return;
		}
		//获取一个数字，并获取该数字对应的字母组
		char digit = digits.charAt(index);
		String letters = map.get(digit);
		for (int i = 0; i < letters.length(); i++) {
			//做选择，获取到当前数字的一个字母，加到track中去
			track.append(letters.charAt(i));
			backtrack(index + 1, digits, track);
			track.deleteCharAt(index);
		}
	}
	
	public int strStr(String haystack, String needle) {
		int L = needle.length(), s = haystack.length();
		for(int start = 0; start + L - 1 < s; start++){
			if(haystack.substring(start, start + L -1).equals(needle)) return start;
		}
		return -1;
	}
}
