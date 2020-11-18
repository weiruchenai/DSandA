package com.dataStuctureAndAlgorithm.LeetCode.BinarySearch;

import java.util.HashSet;
import java.util.Set;

/*
*   349.查询两个数组的交集
*       给定两个数组，编写一个函数来计算它们的交集。交集元素唯一，顺序不要求
* */
public class ArrayIntersection_349 {
	/*
    public int[] intersection(int[] nums1, int[] nums2) {
        //思路是其中一个数组的每个元素，到另一个数组中去进行查找
        Set<Integer> set = new HashSet<>();
        //nums1中的每个元素去nums2中查找
        for(int num1 : nums1){
            for(int num2 : nums2){
                if(num1 == num2) set.add(num1);
            }
        }
        int index = 0;
        int[] res = new int[set.size()];
        for(Integer num : set){
            res[index] = num;
            index++;
        }
        return res;
    }*/
	
	public int[] intersection(int[] nums1, int[] nums2) {
		//用两个set来存放数组元素，set中contains方法效率高，小的那个去大的那个中遍历
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		Set<Integer> resultSet = new HashSet<>();
		//nums1中的每个元素去nums2中查找
		for(int num1 : nums1) set1.add(num1);
		for(int num2 : nums2) set2.add(num2);
		
		for(Integer num : set1){
			if(set2.contains(num)) resultSet.add(num);
		}
		
		int index = 0;
		int[] res = new int[resultSet.size()];
		for(Integer num : resultSet){
			res[index] = num;
			index++;
		}
		return res;
	}
}
