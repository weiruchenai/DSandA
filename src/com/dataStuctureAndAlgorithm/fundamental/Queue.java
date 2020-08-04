package com.dataStuctureAndAlgorithm.fundamental;

import java.util.Arrays;

public class Queue {
    public static void main(String[] args) {
        //顺序队列测试
        /*ArrayQueue aq = new ArrayQueue(5);
        aq.enqueue("0");
        aq.enqueue("1");
        aq.enqueue("2");
        aq.enqueue("3");
        aq.enqueue("4");
        System.out.println(aq.toString());
        String out = aq.dequeue();
        System.out.println(out);
        System.out.println(aq.toString());
        aq.enqueue("5");
        System.out.println(aq.toString());*/

        //循环队列测试
        CircularQueue cq = new CircularQueue(5);
        cq.enqueue("0");
        cq.enqueue("1");
        cq.enqueue("2");
        cq.enqueue("3");
        System.out.println(cq.enqueue("4"));
        System.out.println(cq.toString()); //结果显示可以看到，当队列满时，tail指向的索引是不存储数据的，也就是说循环队列会浪费一个索引的空间
        String out1 = cq.dequeue();
        System.out.println(out1);
        cq.enqueue("5");
        System.out.println(cq.toString());

    }
}

//数组实现的顺序队列
class ArrayQueue{
    private String[] items;//为队列声明一个数组
    private int n = 0; //队列长度
    private int head = 0; //队列头的下标
    private int tail = 0;// 队列尾的下标

    //构造函数为调用后，创建一个大小为capacity的数组
    public ArrayQueue(int capacity) {
        this.items = new String[capacity];
        this.n = capacity;
    }

    public  boolean enqueue(String item){
        //若tail = n ，则队列已满
        if(tail == n ){
            if(head == 0)return false; //head = 0 && tail = n 时代表队列已满
            else {
                //若head != 0，则代表仍有空间，但数据进不来了，需要进行数据转移,转移后首位下标改变
                for (int i = head; i < tail; i++) {
                    items[i - head] = items[i];
                }
                tail = tail - head;
                head = 0;
            }
        }
        items[tail] = item;
        ++tail;
        return true;
    }

    public String dequeue(){
        if(head == tail) return null;
        String ret = items[head];
        items[head] = null;
        ++head;
        return ret;
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "items=" + Arrays.toString(items) +
                ", n=" + n +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
}

//数组实现的循环队列
/*
    队满时，tail与head同时前进一格；
    关键是找到队空队满的判定条件 && tail与head如何移动
    队空条件为head = tail；队满为(tail + 1) % n = head
    tail 变为 (tail + 1) % n； head变为(head + 1) % n
*/
class CircularQueue{
    private String[] items;//为队列声明一个数组
    private int n = 0; //队列长度
    private int head = 0; //队列头的下标
    private int tail = 0;// 队列尾的下标

    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String item){
        if((tail + 1) % n == head) return false; //队满时无法放入数据
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    public String dequeue(){
        if(tail == head ) return null;
        String ret = items[head];
        items[head] = null;
        head = (head + 1) % n;
        return ret;
    }

    @Override
    public String toString() {
        return "CircularQueue{" +
                "items=" + Arrays.toString(items) +
                ", n=" + n +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
}

