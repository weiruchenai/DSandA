package com.dataStuctureAndAlgorithm.LeetCode.Backtracking;

import java.util.LinkedList;
import java.util.List;

/*
*       401. 二进制手表
*           二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
*           每个 LED 代表一个 0 或 1，最低位在右侧。
*           给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
*
*           输出的顺序没有要求。
*           小时不会以零开头，比如 “01:00”是不允许的，应为 “1:00”。
*           分钟必须由两位数组成，可能会以零开头，比如 “10:2”是无效的，应为 “10:02”。
*           超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。
* */
public class BinaryWatch_401 {
	List<String> result = new LinkedList<>();
	/*这边用数组存放表盘的相应数字作为选择列表， 路径分为小时和分钟，为int数，路径更新时直接往上加数字就行*/
	public List<String> readBinaryWatch(int num) {
		int[] nums = {8,4,2,1,32,16,8,4,2,1};
		backtrack(num, nums, 0, 0, 0);
		return result;
	}
	
	public void backtrack(int num, int[] nums, int numsIndex, int hour, int minute){
		if(num == 0){
			//判断时间是否符合要求，不符合则结束return
			if(hour > 11 || minute > 59) return;
			//调用方法生成时间并存入result
			result.add(generateTime(hour, minute));
			return;
		}
		
		for (int i = numsIndex; i < nums.length; i++) {
			//进行回溯，做选择
			//判断是小时还是分钟, 并加入路径
			if(i < 4) hour += nums[i];
			else minute += nums[i];
			//回溯
			backtrack(num - 1, nums, i + 1, hour, minute);
			//撤销选择
			if(i < 4) hour -= nums[i];
			else minute -= nums[i];
		}
	}
	
	private String generateTime(int hour, int minute) {
		StringBuilder time = new StringBuilder();
		time.append(hour).append(":");
		if(minute < 10){
			time.append(0).append(minute);
		}else time.append(minute);
		return time.toString();
	}
	
	
	public static void main(String[] args) {
		BinaryWatch_401 b = new BinaryWatch_401();
		System.out.println(b.readBinaryWatch(2));
	}
}
