package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

import java.util.*;

/*
* 107. 二叉树的层次遍历 II
* 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
* */
public class InverseLevelOrderBT {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		LinkedList<List<Integer>> tree = new LinkedList<>();
		if(root == null) return tree;
		queue.offer(root);
		while (!queue.isEmpty()){
			int count = queue.size();
			List<Integer> level = new LinkedList<>();
			//遍历当前层，并将当前层的节点作为一个list存入level list
			while (count > 0) {
				TreeNode currentNode = queue.poll();
				level.add(currentNode.val);
				if (currentNode.left != null) {
					queue.offer(currentNode.left);
				}
				if (currentNode.right != null) {
					queue.offer(currentNode.right);
				}
				count--;
			}
			//将当前层存入tree list
			tree.addFirst(level);
		}
		return tree;
	}
}
