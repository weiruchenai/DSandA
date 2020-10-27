package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

import java.util.LinkedList;
import java.util.List;

/*
*   653. 两数之和 IV - 输入 BST
*   给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
*
*   思路：遍历BST，将sum - root。val的值存入一个列表，递归遍历时若列表中存在root.val返回true
*
* */
public class BSTFindSum_653 {
	List<Integer> list = new LinkedList<>();
	public boolean findTarget(TreeNode root, int k) {
		if(root == null) return false;
		
		if(list.contains(root.val)) return true;
		list.add(k - root.val);
		
		return findTarget(root.left, k) || findTarget(root.right, k);
	}
}
