package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

import java.util.LinkedList;
import java.util.List;

/*
* 108. 将有序数组转换为二叉搜索树
* */
public class ArrayToBST_100 {
	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums == null) return null;
		return sortedArrayToBST(nums, 0, nums.length - 1);
	}
	
	public TreeNode sortedArrayToBST(int[] nums, int left, int right){
		if(left > right) return null;
		// 总是选择中间位置靠左的那个为根节点
		int rootIndex = (right - left) / 2 + left;
		TreeNode root = new TreeNode(nums[rootIndex]);
		root.left = sortedArrayToBST(nums, left, rootIndex - 1);
		root.right = sortedArrayToBST(nums, rootIndex + 1, right);
		return root;
	}
	
}
