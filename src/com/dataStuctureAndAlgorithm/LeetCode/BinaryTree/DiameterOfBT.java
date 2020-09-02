package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

/*
* 543. 二叉树的直径
* 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
*
* 思路：1、首先最大路径总和一定是叶子节点到叶子结点
*      2、对于任意节点，穿过这个节点的最大路径 = 该节点 的左侧最大深度 + 右侧最大深度
*      3、当最大路径 超过 直径时进行替代
* */
public class DiameterOfBT {
	int dia = 0;
	public int diameterOfBinaryTree(TreeNode root) {
		if(root == null) return 0;
		
		//前序遍历
		int curDia = getMaxDepth(root.left) + getMaxDepth(root.right);
		if(curDia > dia) dia = curDia;
		
		diameterOfBinaryTree(root.left);
		diameterOfBinaryTree(root.right);
		return dia;
	}
	
	public int getMaxDepth(TreeNode root){
		if (root == null) return 0;
		return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
	}
}
