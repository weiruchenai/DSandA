package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

/*
* 235. 二叉搜索树的最近公共祖先
* 中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
*
* 思路：对于root而言，两种情况
*       1、pq在root的两侧，则返回root
*       2、pq在root的一侧。则递归调用左节点或右节点
*       3、root等于p或者q，则返回p或者q
* */
public class BSTNearestCommonRoot_235 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null) return null;

		if(p.val == root.val) return p;
		if(q.val == root.val) return q;
		
		//若pq在root的同一侧，递归
		if(p.val < root.val && q.val < root.val ) return lowestCommonAncestor(root.left, p, q);
		else if(p.val > root.val && q.val > root.val)  return lowestCommonAncestor(root.right, p, q);
		else return root;
	}
	
}
