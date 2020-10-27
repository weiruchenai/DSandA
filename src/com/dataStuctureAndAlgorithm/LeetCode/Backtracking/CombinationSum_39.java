package com.dataStuctureAndAlgorithm.LeetCode.Backtracking;

import java.util.LinkedList;
import java.util.List;

/*
*       39. 组合总和
*           给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
* */
public class CombinationSum_39 {
	List<List<Integer>> result = new LinkedList<>();
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<Integer> track = new LinkedList<>();
		backtrack(candidates, track, target, 0, 0);
		return result;
	}
	
	private void backtrack(int[] candidates, List<Integer> track, int target, int sum, int index) {
		if(sum > target) return;
		if(sum == target){
			result.add(new LinkedList<>(track));
			return;
		}
		
		for (int i = index; i < candidates.length; i++) {
			track.add(candidates[i]);
			sum += candidates[i];
			
			backtrack(candidates, track, target, sum, i);
			
			track.remove(track.size() - 1);
			sum -= candidates[i];
		}
	}
}
