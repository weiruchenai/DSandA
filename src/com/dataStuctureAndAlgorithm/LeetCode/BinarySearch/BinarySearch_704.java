package com.dataStuctureAndAlgorithm.LeetCode.BinarySearch;

import java.util.HashSet;

/*
*   704. 二分查找
*   给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1
* */
public class BinarySearch_704 {
	public int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right){
			int mid = left + (right - left) / 2;
			if(nums[mid] < target) left = mid + 1;
			else if(target < nums[mid]) right = mid - 1;
			else if(target == nums[mid]) return mid;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		BinarySearch_704 binarySearch704 = new BinarySearch_704();
		int[] nums = {1,2,3,4,5,6,7,8,9};
		//System.out.println(binarySearch704.search(nums, 0));
		HashSet<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		Integer[] result = (Integer[]) set.toArray(new Integer[set.size()]);
		int[] res = new int[result.length];
		for(int i = 0; i < result.length; i++){
			res[i] = result[i];
		}
		System.out.println(res);
	}
}
