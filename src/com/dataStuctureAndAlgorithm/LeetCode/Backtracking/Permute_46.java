package com.dataStuctureAndAlgorithm.LeetCode.Backtracking;

import java.util.LinkedList;
import java.util.List;

public class Permute_46 {
	List<List<Integer>> result = new LinkedList<>();
	public List<List<Integer>> permute(int[] nums) {
		LinkedList<Integer> track = new LinkedList<>();
		backtrack(nums, track);
		return result;
	}
	
	public void backtrack(int[] nums, LinkedList<Integer> track){
		if(track.size() == nums.length){
			result.add(new LinkedList<>(track));
			return;
		}
		
		for (int num : nums) {
			//若路径中已经有该元素则不再递归，直接跳到下一轮循环，避免全排列中出现重复元素。作用是省去了选择列表中删除和撤销的操作
			if(track.contains(num)) continue;
			//做出选择
			track.add(num);
			//进入下一层决策树
			backtrack(nums, track);
			//撤销选择：删除上一个选择(路径中最后一个元素)，并重选
			track.removeLast();
		}
	}
	
	public static void main(String[] args) {
		Permute_46 p = new Permute_46();
		int[] nums = {1,2,3};
		System.out.println(p.permute(nums));
	}
}
