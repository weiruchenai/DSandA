package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.List;

/*
* 剑指 Offer 54. 二叉搜索树的第k大节点
*
* 思路：倒着中序遍历，从大到小排列，第k大即为第k个元素
*      节约内存，在找到第k个的时候就停下来
* */
public class BTKthNode_offer54 {
	List<Integer> list = new LinkedList<>();
	public int kthLargest(TreeNode root, int k) {
		if(root == null) return 0;
		traverse(root, k);
		return list.get(k - 1);
	}
	
	public void traverse(TreeNode root, int k){
		if(root == null) return;
		traverse(root.right, k);
		if(list.size() <= k)list.add(root.val);
		traverse(root.left, k);
	}
}
