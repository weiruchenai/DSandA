package com.dataStuctureAndAlgorithm.LeetCode.BST;

import java.util.LinkedList;
import java.util.Queue;

/*
*   116. 填充每个节点的下一个右侧节点指针
*       给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。
*       填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
*       初始状态下，所有next 指针都被设置为 NULL。
* */
public class ConnectNode_116 {
	public Node connect(Node root) {
		if(root == null) return null;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()){
			int size = queue.size();
			//遍历当前层
			for(int i = 0; i < size; i++){
				Node cur = queue.poll();
				//执行插入操作
				if(i < size - 1) cur.next = queue.peek();
				//将当前节点的相邻节点存入队列
				if(cur.left != null) queue.offer(cur.left);
				if(cur.right != null) queue.offer(cur.right);
			}
		}
		return root;
	}
	
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		queue.poll();
		System.out.println(queue.peek());
	}
}

class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;
	
	public Node() {}
	
	public Node(int _val) {
		val = _val;
	}
	
	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
};
