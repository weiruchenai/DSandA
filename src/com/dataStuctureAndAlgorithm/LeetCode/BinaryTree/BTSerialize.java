package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
* 297. 二叉树的序列化与反序列化
* 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，、
* 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
* 序列化，前序遍历，将树中的节点的值存入sb，遇到空则存#替代
* 反序列化，首先找到根节点（前序遍历为第一个元素），紧跟着的是root.left，完了之后是root.right
* */
public class BTSerialize {
	// Encodes a tree to a single string.
	String NULL = "#";
	String SEQ = ",";
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		return sb.toString();
	}
	
	public void serialize(TreeNode root, StringBuilder sb){
		if(root == null){
			sb.append(NULL).append(SEQ);
			return;
		}
		
		// 前序遍历位置
		sb.append(root.val).append(SEQ);
		
		serialize(root.left, sb);
		serialize(root.right, sb);
	}
	
	
	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		//将字符串转化成列表
		LinkedList<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
		return deserialize(nodes);
	}
	
	//用列表构造TreeNode
	public TreeNode deserialize(LinkedList<String> nodes){
		if(nodes.isEmpty()) return null;
		
		//前序遍历位置，最左侧的即为根节点
		String first = nodes.removeFirst();
		if(first.equals(NULL)) return null;
		TreeNode root = new TreeNode(Integer.parseInt(first));
		
		root.left = deserialize(nodes);
		root.right = deserialize(nodes);
		return root;
	}
}
