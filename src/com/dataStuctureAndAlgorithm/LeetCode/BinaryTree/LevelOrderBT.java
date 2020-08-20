package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* 102. 二叉树的层序遍历
* 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
* */
public class LevelOrderBT {
	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> tree = new LinkedList<>();
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
			tree.add(level);
		}
		return tree;
	}
}
