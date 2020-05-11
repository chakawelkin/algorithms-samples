package com.chaka.algorithms.stack;

import java.util.Stack;

/**
 * 最小栈
 *  1、辅助栈
 *  {@code
 *  class MinStack {
 *
 *     private Stack<Integer> data;
 *
 *     private Stack<Integer> helper;
 *
 *     public MinStack() {
 *         this.data = new Stack<>();
 *         this.helper = new Stack<>();
 *     }
 *
 *     public void push(int x) {
 *         data.push(x);
 *         //如下是，每一步操作都要记录一下当前操作后该栈中的最小值
 *         if (helper.empty() || helper.peek() >= x){
 *             helper.push(x);//记录当前的最小值
 *         }else {
 *             helper.push(helper.peek());
 *         }
 *     }
 *
 *     public void pop() {
 *         if (!data.empty()){
 *             data.pop();
 *             helper.pop();
 *         }
 *     }
 *
 *     public int top() {
 *         if (!data.empty()){
 *             return data.peek();
 *         }
 *         return -1;
 *     }
 *
 *     public int getMin() {
 *         if (!helper.empty()){
 *             return helper.peek();
 *         }
 *         return -1;
 *     }
 *
 * }
 *  }
 *  2、自己实现栈
 *      -- 基于单链表实现
 */
public class MinStack {

    private Node node;

    public MinStack() {
    }

    public void push(int x) {
        if (node == null){
            node = new Node(x,x);
        }else {
            node = new Node(x,Math.min(node.min,x),node);
        }
    }

    public void pop() {
        if (node != null) {
            node = node.next;
        }
    }

    public int top() {
       if (node != null){
           return node.val;
       }
       return -1;
    }

    public int getMin() {
        if (node != null){
            return node.min;
        }
        return -1;
    }

    private class Node{
        int val;
        int min;
        Node next;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.getMin());
    }

}