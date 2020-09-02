package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

import com.sun.source.tree.Tree;

/*
*   563. 二叉树的坡度
*   给定一个二叉树，计算整个树的坡度。一
*   个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
*   整个树的坡度就是其所有节点的坡度之和。
*
*   思路：1、定义一个方法，获取一个节点的坡度
*           1.1 定义一个方法，获取一个节点子树的和
*           1.2 对于当前节点，只需获取左子树右子树的和的差的绝对值即为节点坡度
*        2、遍历树，遍历时调用1方法，将每个节点的坡度相加得到整个树的坡度
* */
public class BTTilt {
	int treeTilt;
	public int findTilt(TreeNode root) {
		if(root == null) return 0;
		findTreeTilt(root);
		return treeTilt;
	}
	
	public void findTreeTilt(TreeNode root){
		if(root == null) return;
		
		treeTilt += findNodeTilt(root);
		
		findTilt(root.left);
		findTilt(root.right);
	}
	
	//找到节点的坡度
	public int findNodeTilt(TreeNode root){
		return Math.abs(findNodeSum(root.left) - findNodeSum(root.right));
	}
	
	//找到TreeNode所有节点和
	public int findNodeSum(TreeNode root){
		if(root == null) return 0;
		return root.val + findNodeSum(root.left) + findNodeSum(root.right);
	}
}
