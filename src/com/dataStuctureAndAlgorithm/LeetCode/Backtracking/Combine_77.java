package com.dataStuctureAndAlgorithm.LeetCode.Backtracking;

import java.util.LinkedList;
import java.util.List;

/*
*       77. 组合
*           给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合
* */
public class Combine_77 {
	List<List<Integer>> result = new LinkedList<>();
	public List<List<Integer>> combine(int n, int k) {
		LinkedList<Integer> track = new LinkedList<>();
		backtrack(n, k, 1, track);
		return result;
	}
	
	private void backtrack(int n, int k, int index, LinkedList<Integer> track) {
		if(track.size() == k){
			result.add(new LinkedList<>(track));
			return;
		}
		
		for (int i = index; i <= n; i++) {
			if(track.contains(i) || (track.size() != 0 && track.getLast() > i)) continue;
			track.add(i);
			backtrack(n, k, index + 1, track);
			track.removeLast();
		}
	}
	
	public static void main(String[] args) {
		Combine_77 c = new Combine_77();
		System.out.println(c.combine(4, 2));
		
	}

}
