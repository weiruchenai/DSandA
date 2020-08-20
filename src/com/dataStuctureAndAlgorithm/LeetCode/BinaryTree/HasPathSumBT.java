package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

import java.util.LinkedList;
import java.util.List;

/*
* 112. 路径总和
* 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
*
* 思路：
* 求和，找出每一条路径，当且仅当左右连个节点都为null，才返回pathSum
* 计算路径和比较，一旦等于sum就返回true
* */
public class HasPathSumBT {
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) return sum == 0;
		List<Integer> pathSums = new LinkedList<>();
		int pathSum = 0;
		return getPathSums(root, pathSums, pathSum).contains(sum);
	}
	
	public List<Integer> getPathSums(TreeNode root, List<Integer> pathSums,int pathSum){
		if(root == null) return pathSums;
		pathSum += root.val;
		
		//前序遍历位置
		if(root.right == null && root.left == null) pathSums.add(pathSum);
		
		getPathSums(root.left, pathSums, pathSum);
		getPathSums(root.right, pathSums, pathSum);
		return pathSums;
	}
	
	public boolean hasPathSum2(TreeNode root, int sum) {
		if(root == null) return sum == 0;
		if(root.left == null && root.right == null) return sum - root.val == 0;
		return hasPathSum2(root.left, sum - root.val) || hasPathSum2(root.right, sum - root.val);
	}
}
