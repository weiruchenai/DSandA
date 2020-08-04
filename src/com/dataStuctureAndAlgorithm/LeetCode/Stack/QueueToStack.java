package com.dataStuctureAndAlgorithm.LeetCode.Stack;


import java.util.LinkedList;
import java.util.Queue;

/*
*   思路：用双队列实现操作
*       1、保持一个队列始终为空，只有在有元素进来时添加
*       2、将另一个队列依次poll并赋值给该队列，这样保持了新元素在队列的头，pop和peek时都是返回队列的头，顺序维持先进后出
*       3、完成后另一个队列尾空，两个队列再交换位置，重复1
*
* */
public class QueueToStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    /** Initialize your data structure here. */
    public QueueToStack() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
        while (!q2.isEmpty()) q1.add(q2.poll());
        Queue<Integer> temp;
        temp = q1;
        q1 = q2;
        q2 = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q2.poll();
    }

    /** Get the top element. */
    public int top() {
        return q2.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q2.isEmpty();
    }
}
