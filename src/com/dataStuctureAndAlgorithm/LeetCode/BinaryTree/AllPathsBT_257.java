package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

import java.util.LinkedList;
import java.util.List;

/*
* 257. 二叉树的所有路径
* 给定一个二叉树，返回所有从根节点到叶子节点的路径, 格式["1->2->5", "1->3"]
* */
public class AllPathsBT_257 {
	List<String> paths = new LinkedList<>();
	String SEQ = "->";
	public List<String> binaryTreePaths(TreeNode root) {
		//StringBuilder sb = new StringBuilder();
		String sb = "";
		binaryTreePaths(root, sb);
		return paths;
	}
	
	public void binaryTreePaths(TreeNode root, String sb){
		if(root == null) return ;
		
		//前序遍历位置
		if(root.left != null || root.right != null ) {
			//sb.append(root.val).append(SEQ);
			sb += root.val + SEQ;
		}
		if(root.left == null && root.right == null){
			//sb.append(root.val);
			sb += root.val;
			paths.add(sb.toString());
			return;
		}
		
		binaryTreePaths(root.left, sb);
		binaryTreePaths(root.right, sb);
	}
	
	public static void main(String[] args) {
		StringBuilder s1 = new StringBuilder("111");
		StringBuilder s2 = s1;
		s1.append("222");
		System.out.println(s2);
	}
	
}
