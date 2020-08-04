package com.dataStuctureAndAlgorithm.LeetCode.Stack;

import java.util.Stack;

/*
*   思路：当栈为空一直push，栈不为空，peek比较是否相同，相同则pop
*   pop后再pop重复上述步骤，知道不相同在push
* */
public class DeleteNeighborDuplicate {
    public String removeDuplicates(String S) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] chars = S.toCharArray();
        for (char c : chars) {
            if(stack.isEmpty()) stack.push(c);
            else{
                if (stack.peek() == c) stack.pop();
                else  stack.push(c);
            }
        }
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        DeleteNeighborDuplicate deleteNeighborDuplicate = new DeleteNeighborDuplicate();
        System.out.println(deleteNeighborDuplicate.removeDuplicates("abbaca"));
    }
}
