package com.dataStuctureAndAlgorithm.LeetCode.BST;

import com.dataStuctureAndAlgorithm.LeetCode.BinaryTree.TreeNode;

import java.util.*;

/*
1625. 执行操作后字典序最小的字符串
	给你一个字符串 s 以及两个整数 a 和 b 。其中，字符串 s 的长度为偶数，且仅由数字 0 到 9 组成。
	你可以在 s 上按任意顺序多次执行下面两个操作之一：
	累加：将 a 加到 s 中所有下标为奇数的元素上（下标从 0 开始）。数字一旦超过 9 就会变成 0，如此循环往复。
		例如，s = "3456" 且 a = 5，则执行此操作后 s 变成 "3951"。
	轮转：将 s 向右轮转 b 位。例如，s = "3456" 且 b = 1，则执行此操作后 s 变成 "6345"。
	请你返回在 s 上执行上述操作任意次后可以得到的 字典序最小 的字符串。
	如果两个字符串长度相同，那么字符串 a 字典序比字符串 b 小可以这样定义：在 a 和 b 出现不同的第一个位置上，字符串 a 中的字符出现在字母
	表中的时间早于 b 中的对应字符。例如，"0158” 字典序比 "0190" 小，因为不同的第一个位置是在第三个字符，显然 '5' 出现在 '9' 之前。
*/
public class FindLexSmallestString_1625 {
	
	public String findLexSmallestString(String s, int a, int b) {
		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		queue.offer(s);
		visited.add(s);
		String min = s;
		
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				String cur = queue.poll();
				min = findMin(cur, min);
				
				//将当前的相邻节点加入队列
				String add = add(cur, a);
				String shift = shift(cur, b);
				if(!visited.contains(add)){
					queue.offer(add);
					visited.add(add);
				}
				if(!visited.contains(shift)){
					queue.offer(shift);
					visited.add(shift);
				}
			}
		}
		return min + visited.toString();
	}
	
	public String add(String s, int a){
		char[] chs = s.toCharArray();
		for(int i = 0; i < chs.length; i++){
			if(i % 2 == 1){
				char temp = chs[i];
				if(temp + a <= '9')
					chs[i] = (char)(temp + a);
				if(temp + a > '9')
					chs[i] = (char)(temp + a - 10);
			}
		}
		return new String(chs);
	}
	
	public String shift(String s, int b){
		char[] chs = s.toCharArray();
		for(int i = 0; i < b; i++){
			char lastch = chs[chs.length - 1];
			for(int j = chs.length - 1; j >= 0; j--){
				if(j == 0) chs[0] = lastch;
				else chs[j] = chs[j - 1];
			}
		}
		return new String(chs);
	}
	
	public String findMin(String cur , String min){
		char[] chCur = cur.toCharArray();
		char[] chMin = min.toCharArray();
		for (int i = 0; i < chCur.length; i++) {
			if (chCur[i] == chMin[i]) continue;
			if (chCur[i] > chMin[i]) break;
			if (chCur[i] < chMin[i]) {
				min = cur;
				break;
			}
		}
		return min;
	}
	public static void main(String[] args) {
		FindLexSmallestString_1625 f = new FindLexSmallestString_1625();
		System.out.println(f.findLexSmallestString("87144140372271458627", 4, 8));
		System.out.println(f.findMin("", ""));
		System.out.println();
	}
}
