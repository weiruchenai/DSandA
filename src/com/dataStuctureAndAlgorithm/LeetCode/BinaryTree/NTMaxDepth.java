package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
*   559. N叉树的最大深度
*
*   思路： 获取所有子节点的最大深度l，那么N叉数的最大深度就是l + 1
* */
public class NTMaxDepth {
	List<Integer> childrenMaxDepths = new LinkedList<>();
	public int maxDepth(Node root) {
		if(root == null) return 0;
		if(root.children.isEmpty()) return 1;
		for (Node children : root.children) {
			childrenMaxDepths.add(maxDepth(children));
		}
		return Collections.max(childrenMaxDepths) + 1;
	}
	
}
