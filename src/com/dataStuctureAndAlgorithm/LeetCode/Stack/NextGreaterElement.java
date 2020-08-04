package com.dataStuctureAndAlgorithm.LeetCode.Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/*
*   先遍历大数组nums2，首先将第一个元素入栈；
*       继续遍历，当前元素小于栈顶元素时，继续将它入栈；
*       当当前元素大于栈顶元素时，栈顶元素出栈
*       此时应将该出栈的元素与当前元素形成key-value键值对，存入HashMap中；
*   当遍历完nums2后，得到nums2中元素所对应的下一个更大元素的hash表；
*   遍历nums1的元素在hashMap中去查找‘下一个更大元素’，当找不到时则为-1。
*
* */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                hashMap.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        while(!stack.isEmpty()){
            hashMap.put(stack.pop(), -1);
        }
        for (int i = 0; i < nums1.length; i++) {
            result[i] = hashMap.get(nums1[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        int[] num1 = {2, 1, 7, 4};
        int[] num2 = {1, 2, 8, 7, 4, 5};
        System.out.println(Arrays.toString(nextGreaterElement.nextGreaterElement(num1, num2)));
    }
}
