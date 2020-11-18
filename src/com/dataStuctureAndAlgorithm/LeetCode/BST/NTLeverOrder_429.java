package com.dataStuctureAndAlgorithm.LeetCode.BST;

import com.dataStuctureAndAlgorithm.LeetCode.BinaryTree.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
*       429. N叉树的层序遍历
*            给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
*
* */
public class NTLeverOrder_429 {
	public List<List<Integer>> levelOrder(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		List<List<Integer>> result = new LinkedList<>();
		if(root == null) return result;
		
		while(!queue.isEmpty()){
			int size = queue.size();
			List<Integer> level = new LinkedList<>();
			for(int i = 0; i < size; i++){
				Node cur = queue.poll();
				//将当前层的值依次存入List
				level.add(cur.val);
				
				//将当前节点的所有子节点都存入队列
				for(Node child : cur.children){
					queue.offer(child);
				}
				
			}
			result.add(level);
		}
		return result;
	}
}
