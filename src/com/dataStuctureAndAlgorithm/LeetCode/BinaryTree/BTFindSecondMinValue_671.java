package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

/*
*   671. 二叉树中第二小的节点
*       给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为2或0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
*       给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
*
*   思路：基于这个特殊二叉树的性质,根节点一定是最小的节点,
*        这样只要找到左树中的最小值与右树中的最小值，选较小的值
* */
public class BTFindSecondMinValue_671 {
	public int findSecondMinimumValue(TreeNode root) {
		if(root == null) return -1;
		return findMin(root, root.val);
		
	}
	
	public int findMin(TreeNode root, int min){
		if(root == null) return -1;
		if(root.val > min) return root.val;
		int leftMin = findMin(root.left, min);
		int rightMin = findMin(root.right, min);
		return Math.min(leftMin, rightMin);
	}
}
