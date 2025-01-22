package com.chaka.algorithms.list;

import java.util.Arrays;

public class LRUCacheTest {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(2, 1);
        cache.put(2, 2);
//        cache.put(2, 3);
        System.out.println(cache.get(2));       // 返回  1
        cache.put(1, 1);
        cache.put(4, 1);
           // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)

        String abc = "acb";
        byte[] bytes = abc.getBytes();
        Arrays.sort(bytes);
        abc = new String(bytes);
    }

}