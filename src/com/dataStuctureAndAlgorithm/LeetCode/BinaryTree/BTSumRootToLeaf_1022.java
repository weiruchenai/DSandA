package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

import java.util.LinkedList;
import java.util.List;

/*
*   1022. 从根到叶的二进制数之和
*   给出一棵二叉树，其上每个结点的值都是0或1。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数01101，也就是13。
*   对于每一个叶子节点，都有这样一条路径，找出所有叶子节点的和
*
*   思路： 1、找到所有路径，将路径存在,list中
* */
public class BTSumRootToLeaf_1022 {
	List<String> list = new LinkedList<>();
	public int sumRootToLeaf(TreeNode root) {
		String s = "";
		getAllPaths(root, s);
		int sum = 0;
		for (String s1 : list) {
			sum += Integer.parseUnsignedInt(s1, 2);
		}
		return sum;
	}
	
	public void getAllPaths(TreeNode root, String s){
		if(root ==null) return;
		
		if(root.left == null && root.right == null) {
			s += root.val;
			list.add(s);
		}else s += root.val;
		
		getAllPaths(root.left, s);
		getAllPaths(root.right, s);
	}
	
	public static void main(String[] args) {
		System.out.println(Integer.parseUnsignedInt("01001", 2));
	}
}
