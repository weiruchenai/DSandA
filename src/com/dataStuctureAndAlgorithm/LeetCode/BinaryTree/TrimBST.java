package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

/*
*   669. 修剪二叉搜索树
*   给定一个二叉搜索树，同时给定最小边界L和最大边界R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。
*   你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
*
*   思路：对于根节点，三种情况
*        1. root.val < L, 则将root.right传入方法来找回要传入的root
*        2、 root.val > R。则传入root.left来寻找要传入的root
* */
public class TrimBST {
	public TreeNode trimBST(TreeNode root, int L, int R) {
		if(root == null) return root;
		
		if(root.val < L) return trimBST(root.right, L, R);
		if(root.val > R) return trimBST(root.left, L, R);
		
		root.left = trimBST(root.left, L, R);
		root.right = trimBST(root.right, L, R);
		return root;
	}
}
