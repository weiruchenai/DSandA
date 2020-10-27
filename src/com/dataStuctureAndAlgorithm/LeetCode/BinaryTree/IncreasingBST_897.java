package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.List;

/*
*   897. 递增顺序查找树
*   给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
*
*   思路1： 中序遍历原本的树，获取List，并根据List利用循环重新构造一个新的树
*
*   思路2： 中序遍历原本的树，对于当前节点，另其左节点为null，并将其作为上一个节点的右节点。
* */
public class IncreasingBST_897 {
/*	List<Integer> list = new LinkedList<>();
	public TreeNode increasingBST(TreeNode root) {
		traverse(root);
		TreeNode current = new TreeNode(0);
		TreeNode next1 = current;
		for (Integer integer : list) {
			current.right = new TreeNode(integer);
			current.left = null;
			current = current.right;
		}
		return next1.right;
	}
	public void traverse(TreeNode root){
		if(root == null) return;
		traverse(root.left);
		list.add(root.val);
		traverse(root.right);
	}*/
	
	TreeNode pre;
	public TreeNode increasingBST(TreeNode root) {
		if(root == null) return null;
		TreeNode ans = new TreeNode(0);
		pre = ans;
		inorder(root);
		return ans.right;
	}
	
	private void inorder(TreeNode root) {
		if(root == null) return;
		inorder(root.left);
		
		//对于当前节点，另其左节点为null，并将其作为上一个节点的右节点
		root.left = null;
		pre.right = root;
		pre = root;
		
		inorder(root.right);
	}
}
