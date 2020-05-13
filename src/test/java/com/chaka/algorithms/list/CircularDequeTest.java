package com.chaka.algorithms.list;

import com.chaka.algorithms.stack.MyCircularDeque;

public class CircularDequeTest {

    public static void main(String[] args) {
        MyCircularDeque deque = new MyCircularDeque(10);
        deque.insertFront(1);
        deque.insertFront(2);
        deque.insertFront(3);
        deque.insertFront(4);
        deque.insertLast(7);
        deque.insertLast(8);
        deque.insertLast(9);
        deque.insertLast(10);
        deque.insertLast(11);
        System.out.println(deque.isFull());
        deque.insertFront(5);
        System.out.println(deque.isFull());
    }
}
