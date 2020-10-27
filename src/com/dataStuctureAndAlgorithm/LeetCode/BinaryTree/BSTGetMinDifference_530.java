package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

/*
* 530. 二叉搜索树的最小绝对差
* 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
*
* 思路：所有节点非负数，中序遍历从小到大排列
*       对于当前节点，减去前一个节点的值，若差小于当前的min，则替代
*
* */
public class BSTGetMinDifference_530 {
	Integer pre = null;
	Integer min = Integer.MIN_VALUE;
	public int getMinimumDifference(TreeNode root) {
		if(root == null) return 0;
		traverse(root);
		return min;
	}
	
	public void traverse(TreeNode root){
		if(root == null) return;
		traverse(root.left);
		
		//中序遍历
		min = Math.min(Math.abs(root.val - pre), min);
		
		pre = root.val;
		traverse(root.right);
	}
}
