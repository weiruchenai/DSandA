package com.dataStuctureAndAlgorithm.LeetCode.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    /** Initialize your data structure here. */
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.offer(x);
        //从q2中取出来的并放入q1，
        queue2.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue2.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue2.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue2.isEmpty();
    }
}
