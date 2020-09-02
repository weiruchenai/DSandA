package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
*   637. 二叉树的层平均值
*   给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
*
*   思路：1、层序遍历，先声明一个队列与一个List<Integer> list
*        2、将root入队，进行层序遍历，遍历完后，求该层的平均值，并存入list
* */
public class BTAverageOfLevel {
	public List<Double> averageOfLevels(TreeNode root) {
		if(root == null) return null;
		Queue<TreeNode> queue = new LinkedList<>();
		List<Double> list = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()){
			List<Integer> levelList = new LinkedList<>();
			int count = queue.size();
			
			double sum = 0.0;
			double levelSize = 0.0;
			//层序遍历
			while (count > 0){
				TreeNode current = queue.poll();
				//levelList.add(current.val);
				sum += current.val;
				levelSize++;
				if(current.left != null) queue.offer(current.left);
				if(current.right != null) queue.offer(current.right);
				count--;
			}
			
			//计算层平均值并存入list
/*			Double sum = 0.0;
			for (Integer integer : levelList) {
				sum += integer;
			}
			list.add(sum / levelList.size());*/
			list.add(sum / levelSize);
		}
		return list;
	}
}
