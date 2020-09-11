package com.dataStuctureAndAlgorithm.LeetCode.DynamicProgramming;

/*
*   1025. 除数博弈
*       最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
*           1、选出任意x，0<x<N, 且N % x==0，即N能被x整除
*           2、N=N-x
*           AB轮流操作，轮到玩家无法操作时，判定失败
*           A先手，对于任意N，判断A能否赢
*
*   思路：1、若N是奇数，那么N的所有因数都是奇数
*        2、因此若N为偶数，玩家选择-1，那么此时N-1变成了偶数
*        3、因此对于A，一直确保自己拿到的是偶数->并选择-1->那么就能让B一直拿奇数->确保自己拿到偶数
*        4、这样一来，最后能保证A拿到最小偶数2，此时就赢得游戏
*        5、A先手，因此若N为偶数，则A必胜。
*
* */
public class DivisionGame_1025 {
	public boolean divisorGame(int N) {
		return N % 2 == 0;
	}
}
