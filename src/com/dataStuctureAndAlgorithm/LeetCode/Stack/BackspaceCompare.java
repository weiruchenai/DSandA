package com.dataStuctureAndAlgorithm.LeetCode.Stack;

import java.util.Stack;

public class BackspaceCompare {
    public boolean backspaceCompare(String S, String T) {
        return reBuild(S).equals(reBuild((T)));
    }

    public String reBuild(String string){
        Stack<Character> stack = new Stack<>();
        for (char s: string.toCharArray()) {
            if(s == '#' && !stack.isEmpty()){
                stack.pop();
            }else if(Character.isLowerCase(s)){
                stack.push(s);
            }
        }
        return String.valueOf(stack);
    }

    public static void main(String[] args) {
        BackspaceCompare backspaceCompare=new BackspaceCompare();
        System.out.println(backspaceCompare.backspaceCompare("a##c", "#a#c"));
    }
}
