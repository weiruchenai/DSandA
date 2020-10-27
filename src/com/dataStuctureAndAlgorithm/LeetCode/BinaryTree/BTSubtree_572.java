package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

import com.sun.source.tree.Tree;

/*
* 572. 另一个树的子树
* 给定两个非空二叉树 s 和 t，检验s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
*
* 遍历s, 对于每个s的节点，判断该节点是否与t是相同的树
* */
public class BTSubtree_572 {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if(s == null && t == null) return true;
		if(s == null || t == null) return false;
		
		return isSameTree(s, t) || isSubtree(s.right, t) || isSubtree(s.left, t);
		
		
	}
	
	public boolean isSameTree(TreeNode s, TreeNode t){
		if(s == null && t == null) return true;
		if(s == null || t ==null) return false;
		if(s.val != t.val) return false;
		return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
	}
	
}
