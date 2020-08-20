package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

import com.sun.source.tree.Tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
* 110. 平衡二叉树
*给定一个二叉树，判断它是否是高度平衡的二叉树(一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1)
*
* 思路，对于一个root而言，找到左子树和右子树的最大深度，两者相减的绝对值大于1则返回false，否则返回true
*  */
public class BalanceBT {
	public boolean isBalanced(TreeNode root) {
		if(root == null) return true;
		//若当前root的左右子树最大深度差值>1，返回false，否则递归调用
		int depthDiffer = Math.abs(getMaxDepth(root.left) - getMaxDepth(root.right));
		if(depthDiffer > 1) return false;
		return isBalanced(root.left) && isBalanced(root.right);
	}
	
	public int getMaxDepth(TreeNode root){
		if(root == null) return 0;
		int leftHeight = getMaxDepth(root.left);
		int rightHeight = getMaxDepth(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}
}
