package com.dataStuctureAndAlgorithm.LeetCode.BinarySearch;

import java.util.Arrays;

/*
*   34. 在排序数组中查找元素的第一个和最后一个位置
*       给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
*
*   思路：定义两个方法，分别为找到左侧边界与右侧边界
* */
public class BinarySearchRange {
	public int[] searchRange(int[] nums, int target) {
		int[] ints = {0, 0};
		ints[0] = searchLeftRange(nums, target);
		ints[1] = searchRightRange(nums, target);
		return ints;
	}
	
	public int searchLeftRange(int[] nums, int target){
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if(nums[mid] < target) left = mid + 1;
			else if(nums[mid] > target) right = mid - 1;
			//关键，因为要找左边界，因此当target等于mid值时，不返回，而是进一步缩小右边界，
			else if(nums[mid] == target) right = mid - 1;
		}
		
		//上述while终止时，left = right + 1，可能存在数组越界情况，因此分三种情况（1与1.1可合并为一种）
		// 1、target 小于nums中所有值，结束时left = 0，若nums[0] != target 返回-1
		// 1.1、target 在数组的最大最小值之间，但不存在，结束时nums[left] != target 返回-1
		// 2、target 大于nums中所有值，结束时left = nums.length + 1 ,此时数组越界，也返回-1
		if(left >= nums.length || nums[left] != target) return -1;
		return left;
	}
	
	//思路同理
	public int searchRightRange(int[] nums, int target){
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if(nums[mid] < target) left = mid + 1;
			else if(nums[mid] > target) right = mid - 1;
			else if(nums[mid] == target) left = mid + 1;
		}
		
		if(right < 0 || nums[right] != target) return -1;
		return right;
	}
	
	public static void main(String[] args) {
		BinarySearchRange b = new BinarySearchRange();
		int[] i = {5,7,7,8,8,10};
		System.out.println(Arrays.toString(b.searchRange(i, 8)));
	}
}
