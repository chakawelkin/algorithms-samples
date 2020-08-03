package com.chaka.algorithms.dictionary_tree;

/**
 * 并查集
 *     1、主要作用： 解决动态连通性一类问题
 *     参考 <a href="https://blog.csdn.net/dm_vincent/article/details/7655764"/>
 */
public class UF {

    private int[] id;
    private int count;

    public UF(int n) {
        id = new int[n];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;//初始化都指向自己
        }
        count = n;
    }

    void union(int p, int q) {
        //1.union find
        /*
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
                count--;
            }
        }*/

        //2.quick union
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        id[pRoot] = qRoot;
        count--;
    }

    int find(int p) {
        //1.union find
        //return id[p];

        //2.quick find
        while (p != id[p]){
            //路径压缩,将p节点的父节点设置为它的爷爷节点
            id[p] = id[id[p]];
            p = id[p];
        }//寻找root节点
        return p;
    }

    /**
     * return true if they are in the same component
     *
     * @param p
     * @param q
     * @return
     */
    boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    int count() {
        return count;
    }

}
