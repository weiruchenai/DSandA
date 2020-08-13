package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

/*
* 450. 删除二叉搜索树中的节点
* 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用
* */
public class BSTDelete {
	public TreeNode deleteNode(TreeNode root, int key) {
		if(root == null) return null;
		//找到这个数了！里面执行删除操作(分为三种情况)！
		if(root.val == key){
			//1、该节点没有子节点，直接删除,
			if(root.left == null && root.right == null) return null;
			//2、该节点只有一个子节点，让子节点代替自己的位置
			if(root.left == null) return root.right;
			if(root.right == null) return root.left;
			//3、若该节点有两个子节点，那么从左侧树中找到最大的值代替自己的位置,并删除这个最大值
			TreeNode maxNode = getMax(root.left);
			root.val = maxNode.val;
			root.left = deleteNode(root.left, maxNode.val); //删除这个最大值
		}else if(root.val < key){
			root.right = deleteNode(root.right, key);
		}else {
			root.left = deleteNode(root.left, key);
		}
		return root;
	}
	
	public TreeNode getMax(TreeNode node){
		//左节点的子树中，最右侧的即为最大值
		while (node.right != null){
			node = node.right;
		}
		return node;
	}

}
