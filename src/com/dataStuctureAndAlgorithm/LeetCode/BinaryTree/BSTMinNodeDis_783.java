package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

import com.sun.source.tree.Tree;

/*
* 783. 二叉搜索树节点最小距离
* 给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
*
* 思路：1、对于一个root，找到left树中的最大值，与right树中的最小值
*      2、比较root与这两个值的差值，小的那个存入min数值
*      3、得出的min小于当前的min，则进行替换。
*      4、对于root的左右节点，递归
* */
public class BSTMinNodeDis_783 {
	public int minDiffInBST(TreeNode root) {
		if(root == null) return 0;
		return minDiffInBST(root, 100);
	}
	
	public int minDiffInBST(TreeNode root, int currentMin){
		if(root == null) return currentMin;
		int min;
		////找出左树最大值，右树最小值，计算root与他们的差
		if(root.left == null && root.right ==null) return currentMin;
		else if(root.left == null) min = minInRight(root.right).val - root.val;
		else if(root.right == null) min = root.val - maxInLeft(root.left).val;
		else {
			min = Math.min(root.val - maxInLeft(root.left).val, minInRight(root.right).val - root.val);
		}
		if(min < currentMin) currentMin = min;
		//递归，返回左子树或右子树中的差值的最小值
		return Math.min(minDiffInBST(root.left, currentMin), minDiffInBST(root.right, currentMin));
	}
	
	//找出左子树中的最大值，与右子树中的最小值
	public TreeNode maxInLeft(TreeNode root){
		if(root == null) return null;
		while (root.right != null) root = root.right;
		return root;
	}
	public TreeNode minInRight(TreeNode root){
		if(root == null) return null;
		while (root.left != null) root = root.left;
		return root;
	}
	
}
