package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

/*
* 101. 对称二叉树
*   给定一个二叉树，检查它是否是镜像对称的。
* */
public class SymmetricBT_101 {
	public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		return isSymmetric(root.left, root.right);
	}
	
	public boolean isSymmetric(TreeNode left, TreeNode right){
		if(left == null && right == null) return  true;
		if(left == null || right == null) return false;
		if(left.val != right.val) return false;
		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}
}
