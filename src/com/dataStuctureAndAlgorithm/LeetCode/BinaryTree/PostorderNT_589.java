package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

import java.util.LinkedList;
import java.util.List;

/*
* 589. N叉树的前序遍历
* 给定一个 N 叉树，返回其节点值的前序遍历。
* */
public class PostorderNT_589 {
	List<Integer> list = new LinkedList<>();
	public List<Integer> preorder(Node root) {
		if(root == null) return list;
		//前序遍历位置
		list.add(root.val);
		if(root.children.isEmpty()) return list;
		for (Node child : root.children) {
			preorder(child);
		}
		return list;
	}
}
