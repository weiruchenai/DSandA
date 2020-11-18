package com.dataStuctureAndAlgorithm.LeetCode.BST;

import java.util.*;

/*
*       127.单词接龙
*           给定两个单词（beginWord和 endWord）和一个字典，找到从beginWord到endWord的最短转换序列的长度。转换需遵循如下规则：
*           每次转换只能改变一个字母。
*           转换过程中的中间单词必须是字典中的单词。
*           说明:
*           如果不存在这样的转换序列，返回 0。
*           所有单词具有相同的长度。
*           所有单词只由小写字母组成。
*           字典中不存在重复的单词。
*           你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
* */
public class LadderLength_127 {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		Set<String> wordSet = new HashSet<>(wordList);
		
		Map<Integer, Set<Character>> map = getMap(wordList);
		
		queue.offer(beginWord);
		visited.add(beginWord);
		int step = 1;
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				String cur = queue.poll();
				//判断是否到达终点
				if(cur.equals(endWord)) return step;
				
				//将字典中所有与cur相差一个字母的词加入queue
				//cur的所有字母都有一个选择，相应位置换成endword对应的字母
				for(int j = 0; j < beginWord.length(); j++){
					char[] ch1 = cur.toCharArray();
					Set<Character> set = map.get(j);
					//cur的第j位替换成另一个字母
/*					for (Character character : set) {
						if(ch1[j] == character) continue;
						ch1[j] = character;
						String next = new String(ch1);
						//新的String存在词典中并且cur未访问过，就加入队列
						if(wordList.contains(next) && !visited.contains(next)){
							queue.add(next);
							visited.add(next);
						}
					}*/
					for(char character = 'a'; character <= 'z'; character++){
						if(ch1[j] == character) continue;
						ch1[j] = character;
						String next = new String(ch1);
						//新的String存在词典中并且cur未访问过，就加入队列
						if(wordSet.contains(next) && !visited.contains(next)){
							queue.add(next);
							visited.add(next);
						}
					}
				}
			}
			step++;
		}
		//遍历完后仍旧未找到，就再也找不到了
		return 0;
	}
	
	//这个方法获取一个Map<Integer.Set<Character>> 其中key代表词典中每一个词的第i位，共有Set中的候选字母
	private Map<Integer, Set<Character>> getMap(List<String> wordList) {
		Map<Integer, Set<Character>> map = new HashMap<>();
		for (int i = 0; i < wordList.get(0).length(); i++) {
			Set<Character> set = new HashSet<>();
			for (String s : wordList) {
				char[] chars = s.toCharArray();
				set.add(chars[i]);
			}
			map.put(i, set);
		}
		return map;
	}
	
	public static void main(String[] args) {
		LadderLength_127 l = new LadderLength_127();
		List<String> wordList = new LinkedList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("dog");
		wordList.add("log");
		wordList.add("cog");
		System.out.println(l.getMap(wordList));
		System.out.println(l.ladderLength("hit", "cog", wordList));
	}
}
