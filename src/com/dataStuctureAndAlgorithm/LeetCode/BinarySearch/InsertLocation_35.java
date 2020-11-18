package com.dataStuctureAndAlgorithm.LeetCode.BinarySearch;

/*
*   35、给定一个已排序的数组，寻找相应元素在数组中的位置，若数组中不存在，返回该元素应该在数组中插入的位置
* */
public class InsertLocation_35 {
	public int searchInsert(int[] nums, int target) {
		//若元素在数组的边界外
		if(nums[nums.length - 1] < target) return nums.length - 1;
		if(nums[0] > target) return 0;
		
		//进行二分查找
		int left = 0, right = nums.length - 1;
		int result = 0;
		while(left <= right){
			int mid = left + (right - left) / 2;
			//若nums[mid] > target，说明要去mid左侧找，收缩右边界
			if(nums[mid] > target) {
				right = mid - 1;
				//若nums[mid]大于target，nums[mid-1]反而小于target，说明没有target，target应该插入在mid位置
				if(nums[mid - 1] < target) {
					result = mid;
					break;
				}
			}
			//若nums[mid] < target，说明要去mid右侧找，收缩左边界
			else if(nums[mid] < target){
				left = mid + 1;
				//同上
				if(nums[mid + 1] > target) {
					result = mid + 1;
					break;
				}
			}
			else if(nums[mid] == target){
				result = mid;
				break;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		InsertLocation_35 i = new InsertLocation_35();
		int[] nums = {1,2,3,4,5,10};
		System.out.println(i.searchInsert(nums, 2));
	}
}
