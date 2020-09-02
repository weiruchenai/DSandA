package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.List;

/*
* 501. 二叉搜索树中的众数
* 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
*
* 思路：
* 中序遍历BST（相同值的节点都在一起），遍历时记录元素出现的次数，
* 当元素的值发生变化时，将这个次数与已有的次数对比，若等于则将该元素的值放入int[]，若大于的int[]放入该元素
* */
public class BSTFindMode {
	TreeNode pre;
	List<Integer> list = new LinkedList<>();
	public int[] findMode(TreeNode root) {
		if(root == null) return new int[0];
		findModeHelper(root, 0, 0);
		int[] array = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		return array;
	}
	
	public void findModeHelper(TreeNode root, int times, int max){
		if(root == null) return;
		findModeHelper(root.left, times, max);
		
		//中序遍历
		if(pre != null) {
			if (root.val == pre.val) times++;
			
			if (times > max) {
				max = times;
				list.clear();
				list.add(root.val);
			} else if (times == max) {
				list.add(root.val);
			}
			
			if (root.val != pre.val) times = 1;
		}
		
		pre = root;
		findModeHelper(root.right, times, max);
	}
}
