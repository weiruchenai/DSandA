package com.dataStuctureAndAlgorithm.LeetCode.Stack;

import java.util.Stack;

/*
*   思路：用双栈实现队列
*   1、对于栈1，保持始终为空，仅当新元素入栈时，首先将栈2元素全部push如栈1，最后在push入新元素
*   2、这样一来，最早进的元组在栈1的底，最新的元素在栈1的顶
*   3、栈1所有元素push如栈2，两栈互换内容，结束后栈1为空，栈2中新元素沉底，实现先进先出的顺序
* */
public class StackToQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    /** Initialize your data structure here. */
    public StackToQueue(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!stack2.isEmpty()) stack1.push(stack2.pop());
        //将新元素放在栈顶
        stack1.push(x);
        //两栈互换内容，结束后栈1为空，栈2中新元素沉底，实现先进先出的顺序
        while(!stack1.isEmpty()) stack2.push(stack1.pop());
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack2.isEmpty();
    }

    public static void main(String[] args) {
        StackToQueue stackToQueue = new StackToQueue();
        stackToQueue.push(1);
        stackToQueue.push(2);
        stackToQueue.push(3);
        stackToQueue.push(4);
        System.out.println(stackToQueue.pop());
        System.out.println(stackToQueue.pop());
    }
}
