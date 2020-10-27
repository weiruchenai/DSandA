package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

/*
*   687. 最长同值路径
*       给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
*
*   思路：对于当前节点，经过它的最长同值路径 = 左侧的同值路径 + 右侧的通值路径
*
* */
public class BTLongestSameValuePath_687 {
	int longestPath = 0;
	public int longestUnivaluePath(TreeNode root) {
		if(root == null) return 0;
		int curPath = findPartialSameValuePath(root.right, root.val, 0) +
				findPartialSameValuePath(root.left, root.val, 0);
		if(curPath > longestPath) longestPath = curPath;
		
		longestUnivaluePath(root.left);
		longestUnivaluePath(root.right);
		return longestPath;
	}
	
	public int findPartialSameValuePath(TreeNode root, int val, int depth){
		if(root == null || root.val != val) return depth;
		
		depth++;
		
		return Math.max(findPartialSameValuePath(root.left,root.val, depth),
				findPartialSameValuePath(root.right, root.val, depth));
	}
}
