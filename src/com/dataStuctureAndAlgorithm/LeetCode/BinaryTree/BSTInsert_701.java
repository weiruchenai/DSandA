package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;
/*
* 701. 二叉搜索树中的插入操作
* 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 保证原始二叉搜索树中不存在新值。
* 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
*/
public class BSTInsert_701 {
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if(root == null) return new TreeNode(val);
		if(root.val < val){
			//若传入值比当前节点值大，那么对当前节点右侧节点进行插值
			root.right = insertIntoBST(root.right, val);
		}
		if(root.val > val){
			root.left = insertIntoBST(root.left, val);
		}
		return root;
	}
}
