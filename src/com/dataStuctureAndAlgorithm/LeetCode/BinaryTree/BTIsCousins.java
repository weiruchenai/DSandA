package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

/*
*   993. 二叉树的堂兄弟节点
*       如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
*       我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
*       只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
*
*   思路： 1、首先判断深度是否相同，不同则false
*         2、对于每一个节点，记录上一个节点的值，若输入的xy的上一个节点值相同false不同true
* */
public class BTIsCousins {
	int xDepth, yDepth, xParent, yParent;
	public boolean isCousins(TreeNode root, int x, int y) {
		getDepthAndParent(root.left, x, y, 0, root.val);
		getDepthAndParent(root.right, x, y, 0, root.val);
		return xDepth == yDepth && xParent != yParent;
	}
	
	public void getDepthAndParent(TreeNode root, int x, int y, int depth, int parVal) {
		if (root == null) return;
		if (root.val == x) {
			xDepth = depth;
			xParent = parVal;
		}
		if (root.val == y) {
			yDepth = depth;
			yParent = parVal;
		}
		
		getDepthAndParent(root.left, x, y, depth + 1, root.val);
		getDepthAndParent(root.right, x, y, depth + 1, root.val);
	}
}
