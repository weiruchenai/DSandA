package com.dataStuctureAndAlgorithm.LeetCode.BST;

import com.dataStuctureAndAlgorithm.LeetCode.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BTMinDepth {
	/*递归
	List<Integer> depths = new LinkedList<>();
	public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right != null) return minDepth(root.right) + 1;
        if(root.right == null && root.left != null) return minDepth(root.left) + 1;
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}*/
	
	//BFS的方法来做，有点类似于层序遍历的过程
	public int minDepth(TreeNode root) {
		if(root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int depth = 1;
		
		while(!queue.isEmpty()){
			int size = queue.size();
			//当前所有节点向下一层扩散
			for(int i = 0; i < size; i++){
				TreeNode cur = queue.poll();
				//判断是否到达终点：若当前节点没有子节点，则找到离根节点最近的叶子结点，直接返回
				if(cur.left == null && cur.right == null) return depth;
				//将相邻节点加入队列
				if(cur.left != null) queue.offer(cur.left);
				if(cur.right != null) queue.offer(cur.right);
				
			}
			//增加步数
			depth++;
		}
		return depth;
		
	}
}
