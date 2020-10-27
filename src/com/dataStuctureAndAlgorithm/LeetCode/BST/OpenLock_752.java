package com.dataStuctureAndAlgorithm.LeetCode.BST;

import java.util.*;

/*
*       752. 打开转盘锁
*           你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
*           每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字锁的初始数字为 '0000' ，
*           一个代表四个拨轮的数字的字符串。列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，
*           这个锁将会被永久锁定，无法再被旋转。
*           字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
* */
public class OpenLock_752 {
	public int openLock(String[] deadends, String target) {
		Queue<String> queue = new LinkedList<>();
		//将所有deadend节点放到List中去
		Set<String> deadendsList = new HashSet<>(Arrays.asList(deadends));
		Set<String> visited = new HashSet<>();
		visited.add("0000");
		queue.offer("0000");
		int step = 0;
		
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				String cur = queue.poll();
				
				//判断是否到达终点
				if(deadendsList.contains(cur)) continue; //若加入的一个选择是deadend，跳过
				if(cur.equals(target)) return step;
				
				//不到终点，则吧节点的所有8个相邻结果（节点）加入队列
				for(int j = 0; j < 4; j++){
					String plusOne = plusOne(cur, j);
					String minusOne = minusOne(cur, j);
					if(!visited.contains(plusOne)) {
						queue.offer(plusOne);
						visited.add(plusOne);
					}
					if(!visited.contains(minusOne)){
						queue.offer(minusOne);
						visited.add(minusOne);
					}
				}
			}
			step++;
		}
		//遍历完所有结果后没有结果，就再也找不到了
		return -1;
	}
	
	
	//这两个方法作用：四个数中的某个位数向前（向后）拨动后，四个数字组成的String应该怎么变化
	public String plusOne(String s, int index){
		char[] ch = s.toCharArray();
		if(ch[index] == '9') ch[index] = '0';
		else ch[index] += 1;
		return new String(ch);
	}
	
	public String minusOne(String s, int index){
		char[] ch = s.toCharArray();
		if(ch[index] == '0') ch[index] = '9';
		else ch[index] -= 1;
		return new String(ch);
	}
	
	public static void main(String[] args) {
		OpenLock_752 o = new OpenLock_752();
		String[] s = {"0101", "0202", "0303"};
		System.out.println(o.openLock(s, "0001"));
	}
}
