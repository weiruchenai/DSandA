package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

import java.util.LinkedList;
import java.util.List;

/*
*   145、二叉树的后序遍历,对于一个root，先左节点，再右节点，再它自身
* */
public class PostorderBT_146 {
	List<Integer> list = new LinkedList<>();
	//主方法，返回list
	public List<Integer> postorderTraversal(TreeNode root) {
		if(root == null) return list;
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		list.add(root.val);
		return list;
	}
}
