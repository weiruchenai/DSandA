package com.dataStuctureAndAlgorithm.LeetCode.BinaryTree;

/*
* 606. 根据二叉树创建字符串
*       你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
*       空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
*
*  思路：对于任何一个节点，有三种情况：
*       1，如果当前节点有两个孩子，那我们在递归时，需要在两个孩子的结果外都加上()
*       2. 如果当前节点没有孩子，那我们不需要在节点后面加上任何括号；
*       3. 如果当前节点只有左孩子，那我们在递归时，只需要在左孩子的结果外加上一层括号，而不需要给右孩子加上任何括号；
*       4、如果当前节点只有右孩子，那我们在递归时，需要先加上一层空的括号 () 表示左孩子为空，再对右孩子进行递归，并在结果外加上一层括号。
 * */
public class BTToStr_606 {
	StringBuilder sb= new StringBuilder();
	public String tree2str(TreeNode t) {
		if(t == null) return sb.toString();
		tree2str2(t);
		return sb.toString();
	}
	
	public void tree2str2(TreeNode t){
		if(t == null) return;
		
		if(t.left == null && t.right == null) sb.append(t.val);
		if(t.left != null && t.right == null) {
			sb.append(t.val).append("(");
			tree2str2(t.left);
			sb.append(")");
		}
		if(t.left == null && t.right != null) {
			sb.append(t.val).append("()(");
			tree2str2(t.right);
			sb.append(")");
		}
		if(t.left != null && t.right != null) {
			sb.append(t.val).append("(");
			tree2str2(t.left);
			sb.append(")(");
			tree2str2(t.right);
			sb.append(")");
		}
	}
}
