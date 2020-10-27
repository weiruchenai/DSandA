package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

/*
* 226. 翻转二叉树，翻转一颗二叉树
*
* 思路：对于每一个叶子节点，交换左右子树；
*       交换完后，递归到上一层节点
*       因此是个后序遍历的过程
* */
public class ReverseBT_226 {
	public TreeNode invertTree(TreeNode root) {
		if(root == null) return null;
		root.left = invertTree(root.left);
		root.right = invertTree(root.right);
		
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		return root;
	}
}
