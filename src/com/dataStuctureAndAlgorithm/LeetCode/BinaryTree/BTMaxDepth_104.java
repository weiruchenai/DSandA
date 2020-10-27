package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* 104. 二叉树的最大深度
* 给定一个二叉树，找出其最大深度。二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
* */
public class BTMaxDepth_104 {
	
	List<Integer> depths = new LinkedList<>();
	public int maxDepth(TreeNode root) {
		depths = traverse(root, 1);
		if(depths.isEmpty()) return 0;
		return Collections.max(depths);
	}
	
	public List<Integer> traverse(TreeNode root, int depth){
		if(root == null) return depths;
		
		//前序遍历
		if(root.right == null && root.left == null) depths.add(depth);
		
		depth++;
		traverse(root.left, depth);
		traverse(root.right, depth);
		return depths;
	}
}
