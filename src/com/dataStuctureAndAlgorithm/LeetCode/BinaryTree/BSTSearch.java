package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

/*
* 700. 二叉搜索树中的搜索
* 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
* */
public class BSTSearch {
	public TreeNode searchBST(TreeNode root, int val) {
		// 三种情况，root.val与val的对比
		if(root == null || root.val == val) return root;
		else if(root.val < val) {
			return searchBST(root.right, val);
		}
		else {
			return searchBST(root.left, val);
		}
	}
}
