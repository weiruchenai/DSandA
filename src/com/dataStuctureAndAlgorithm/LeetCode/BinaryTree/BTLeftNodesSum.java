package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

/*
* 404. 左叶子之和
* 计算给定二叉树的所有左叶子之和。
*
* 思路： 对于当前节点，左节点不为空则加，否则不加；秭归遍历
* */
public class BTLeftNodesSum {
	public int sumOfLeftLeaves(TreeNode root) {
		if(root == null) return 0;
		int sum = 0;
		return sumOfLeftLeaves(root, sum);
	}
	
	public int sumOfLeftLeaves(TreeNode root, int sum){
		if(root == null) return sum;
		if(root.left != null && root.left.left == null && root.left.right == null) {
			sum += root.left.val;
		}
		sum = sumOfLeftLeaves(root.left, sum);
		sum = sumOfLeftLeaves(root.right, sum);
		return sum;
	}
}
