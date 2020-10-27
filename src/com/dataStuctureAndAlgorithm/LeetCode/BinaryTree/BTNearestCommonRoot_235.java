package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;


public class BTNearestCommonRoot_235 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null) return null;
		
		if(p.val == root.val) return p;
		if(q.val == root.val) return q;
		
		if(isContain(root.left, p) && isContain(root.left, q)) return lowestCommonAncestor(root.left, p, q);
		if(isContain(root.right, p) && isContain(root.right, q)) return lowestCommonAncestor(root.right, p, q);
		else return root;
		
	}
	
	public boolean isContain(TreeNode root, TreeNode x){
		if(root == null) return false;
		if(root.val == x.val) return true;
		return isContain(root.left, x) || isContain(root.right, x);
	}
}
