package com.dataStuctureAndAlgorithm.LeetCode.Backtracking;

import java.util.LinkedList;
import java.util.List;

public class Subsets_78 {
	List<List<Integer>> result = new LinkedList<>();
	public List<List<Integer>> subsets(int[] nums) {
		LinkedList<Integer> track = new LinkedList<>();
		result.add(track);
		backtrack(nums, track, 0);
		return result;
	}
	
	private void backtrack(int[] nums, LinkedList<Integer> track, int index) {
		for (int i = index; i < nums.length; i++) {
			if(track.contains(nums[i])) continue;
			track.add(nums[i]);
			result.add(new LinkedList<>(track));
			backtrack(nums, track, i + 1);
			track.removeLast();
		}
	}
}
