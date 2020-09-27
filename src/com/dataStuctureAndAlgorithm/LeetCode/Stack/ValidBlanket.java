package com.dataStuctureAndAlgorithm.LeetCode.Stack;

import javax.crypto.spec.ChaCha20ParameterSpec;
import java.util.HashMap;
import java.util.Stack;

/*
*   思路：输入一个String，对于String.CharAt(i)来获取每一个String里的元素
*   若当前括号是一个左括号，将其存入Stack.push
*   若当前括号是一个右括号，Stack.pop出一个元素若不匹配则为false
*   若栈深超过string.length / 2，直接return false
*   若全部匹配，则最终栈为空
* */
public class ValidBlanket {

    public boolean solution(String s){
        HashMap<Character, Character> mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put(']', '[');
        mappings.put('}', '{');
        Stack<Character> stack = new Stack<>();
        int depth = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (depth > s.length() / 2) return false;
            else if ( mappings.containsValue(c)){
                stack.push(c); depth++;
            }
            else{
                if (stack.isEmpty() || mappings.get(c) != stack.pop()){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidBlanket stackProblems = new ValidBlanket();
        System.out.println(stackProblems.solution(")"));
    }
}
