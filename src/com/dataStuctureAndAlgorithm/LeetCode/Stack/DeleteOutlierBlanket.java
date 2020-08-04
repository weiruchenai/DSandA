package com.dataStuctureAndAlgorithm.LeetCode.Stack;

/*
*   思路：S必是合法的，不用考虑出现不配对的情况
*   只需计算左括号的个数，直接删掉每个primitive外层括号（当left==0时，当前的'('')'均不放入StringBuilder）
* */
public class DeleteOutlierBlanket {
    public String removeOuterParentheses(String S) {
        char[] chars = S.toCharArray();
        int left = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : chars) {
            if(c == '(' && left++ >0){
                stringBuilder.append("(");
            }else if (c == ')' && --left > 0){
                stringBuilder.append(")");
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        DeleteOutlierBlanket deleteOutlierBlanket = new DeleteOutlierBlanket();
        System.out.println(deleteOutlierBlanket.removeOuterParentheses("(()())(()))"));
    }
}
