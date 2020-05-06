package com.chaka.algorithms.list;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU 缓存
 * 1、查找的时间复杂度是O(1) -- 哈希表
 * 2、删除的时间复杂度也是O(1) -- 顺序链表
 * 3、访问一个数据后需要把节点数据放到队头
 */
public class LRUCache {

    private Node head;

    private Node tail;

    private int capacity;

    private int modCount;

    // 作为hash存储
    private Map<Integer,Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        if (capacity < 0){
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
    }

    /**
     * 获取数据
     * @param key
     * @return
     */
    public int get(int key) {
        Node node = map.get(key);
        if (node == null){
            return -1;
        }
        //首先处理两种极端情况，拿到的就是首节点、尾结点
        if (node == head){
            return node.value;
        }else if (node == tail){
            tail = node.prev;
            tail.next = null;
        }else {
            //抽取该节点
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }
        // 替换头节点
        head.prev = node;
        node.next = head;
        head = node;
        return node.value;
    }

    /**
     * 添加一个新节点
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        // 如果当前节点已经存在，则变更value
        Node exists = map.get(key);
        if (exists != null){
            exists.value = value;
            get(key);
            return;
        }

        // 当容量不够，移除最后一个节点
        if (modCount + 1 > capacity){
            Node node = map.remove(tail.key);//hash表中移除尾结点
            if (capacity == 1){
                head = null;
                tail = null;
            }else {
                tail = node.prev;//前驱节点
                // help gc
                tail.next = null;
                node.prev = null;
                modCount--;
            }
        }
        // 新增节点
        Node node = new Node(key, value);
        modCount++;
        map.put(key,node);
        // first add
        if (tail == null){
            head = node;
            tail = node;
            return;
        }
        // 添加到链表头
        head.prev = node;
        node.next = head;
        this.head = node;
    }

    /**
     * 节点
     */
    static class Node{

        private int key;
        private int value;
        private Node prev;
        private Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

}