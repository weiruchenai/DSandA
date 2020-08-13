package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

import java.util.LinkedList;
import java.util.List;

/*
*   144、二叉树的前序遍历,先自身，再左节点，再右节点
* */
public class PreorderBT {
	//主方法，将二叉树转为List
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<>();
		preorderTraversal(root, list);
		return list;
	}
	
	//辅助方法，将二叉树前序遍历存入List，遇到空则不存
	public void preorderTraversal(TreeNode root, List<Integer> list){
		if(root == null){
			return;
		}
		//下面开始前序遍历
		list.add(root.val);
		//左右节点的递归
		preorderTraversal(root.left, list);
		preorderTraversal(root.right, list);
	}
}
