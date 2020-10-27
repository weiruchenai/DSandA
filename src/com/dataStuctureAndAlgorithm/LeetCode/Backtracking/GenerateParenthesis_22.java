package com.dataStuctureAndAlgorithm.LeetCode.Backtracking;

import java.util.LinkedList;
import java.util.List;

/*
*       22. 括号生成
*           数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
*
* */
public class GenerateParenthesis_22 {
	List<String> result = new LinkedList<>();
	public List<String> generateParenthesis(int n) {
		StringBuilder track = new StringBuilder();
		backtrace(track, 0, 0, n);
		return result;
	}
	
	private void backtrace(StringBuilder track, int left, int right, int n) {
		if(track.length() == 2 * n){
			result.add(track.toString());
			return;
		}
		
		//若左括号小于n，则添加一个左括号
		if(left < n){
			track.append("(");
			backtrace(track, left + 1, right, n);
			//撤销上一次选择，即删除track中最后一个元素
			track.deleteCharAt(track.length() - 1);
		}
		//若有括号小于左括号，则添加一个右括号
		if(right < left){
			track.append(")");
			backtrace(track, left, right + 1, n);
			track.deleteCharAt(track.length() - 1);
		}
	}
}
