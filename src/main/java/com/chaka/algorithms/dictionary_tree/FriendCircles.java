package com.chaka.algorithms.dictionary_tree;

/**
 * <a href="https://leetcode-cn.com/problems/friend-circles/">朋友圈</a>
 */
public class FriendCircles {

    public int findCircleNum(int[][] M) {
        UF uf = new UF(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1){
                    uf.union(i,j);
                }
            }
        }
        return uf.count();
    }

    class UF {

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

        int count() {
            return count;
        }

    }


}