package com.dataStuctureAndAlgorithm.LeetCode.Stack;

import java.util.Stack;

/*
*   轮次为栈，遇到c则弹栈，
* */
public class BaseballContest {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int lastRound, thisRound;
        for (String op : ops) {
            switch (op) {
                case "C":
                    sum -= stack.pop();
                    break;
                case "D":
                    lastRound = stack.peek();
                    stack.push(lastRound * 2);
                    sum += lastRound * 2;
                    break;
                case "+":
                    lastRound = stack.pop();
                    thisRound = lastRound + stack.peek();
                    sum += thisRound;
                    stack.push(lastRound);
                    stack.push(thisRound);
                    break;
                default:
                    sum += Integer.parseInt(op);
                    stack.push(Integer.parseInt(op));
                    break;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        BaseballContest baseballContest = new BaseballContest();
        String[] ops = {"5","-2","4","C","D","9","+","+"};
        System.out.println(baseballContest.calPoints(ops));
    }
}
