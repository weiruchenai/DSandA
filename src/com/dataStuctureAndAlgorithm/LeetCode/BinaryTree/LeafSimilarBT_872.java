package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

import java.util.LinkedList;
import java.util.List;

/*
*   872. 叶子相似的树
*       请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
*
*   思路： 遍历一棵树获取其所有叶子节点的List
*         比较两个List。若长度不同返回false，遍历比较每个值，值不同返回false
* */
public class LeafSimilarBT_872 {

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> list1 = new LinkedList<>();
		List<Integer> list2 = new LinkedList<>();
		list1 = getLeafList(root1, list1);
		list2 = getLeafList(root2, list2);
		
		if(list1.size() != list2.size()) return false;
		for (int i = 0; i < list1.size(); i++) {
			if (!list1.get(i).equals(list2.get(i))) return false;
		}
		return true;
	}
	
	public List<Integer> getLeafList(TreeNode root, List<Integer> list){
		if(root == null) return null;
		
		if(root.left == null && root.right == null) list.add(root.val);
		
		getLeafList(root.left, list);
		getLeafList(root.right, list);
		
		return list;
	}
}
