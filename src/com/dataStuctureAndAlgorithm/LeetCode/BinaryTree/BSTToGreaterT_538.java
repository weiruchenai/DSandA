package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.List;

/*
* 538. 把二叉搜索树转换为累加树
* 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
*
* 思路1：1、中序遍历二叉树，获取二叉树的中序遍历的List
*      2、再次中序遍历，根据List将每个root的值修改为累加树的值
*
* 思路2：中序遍历，从后往前，从大到小排列，每个root的值都为之前的值相加
* */
public class BSTToGreaterT_538 {
	int val = 0;
	public TreeNode convertBST(TreeNode root) {
		//中序遍历，从后往前，从大到小排列，每个root的值都为之前的值相加
		if(root == null) return null;
		convertBST(root.right);
		root.val = root.val + val;
		val = root.val;
		convertBST(root.left);
		return root;
	}
/*	List<Integer> list = new LinkedList<>();
	public TreeNode convertBST(TreeNode root) {
		//中序遍历二叉树，获得从小到大排列的List
		traverse(root);
		getRoot(root);
		return root;
	}
	
	public void traverse(TreeNode root){
		if(root == null) return;
		traverse(root.left);
		list.add(root.val);
		traverse(root.right);
	}
	
	public void getRoot(TreeNode root){
		if(root == null) return;
		getRoot(root.left);
		
		root.val = getValue(root.val);
		
		getRoot(root.right);
	}
	
	public int getValue(int rootVal){
		int val = rootVal;
		for (Integer integer : list) {
			if (rootVal < integer){
				val += integer;
			}
		}
		rootVal = val;
		return rootVal;
	}
	
	public static void main(String[] args) {
		BSTToGreaterT_538 tt = new BSTToGreaterT_538();
		TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(4));
		tt.convertBST(root);
	}*/
}
