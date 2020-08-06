package com.chaka.algorithms.dfs_bfs;

import com.chaka.algorithms.tree.node.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/#/description">在每个树行中找最大值</a>
 *  1、DFS 记录深度，记录深度中的最大值
 *  2、BFS 每一层遍历完成后,找到最大值
 */
public class FindLargestValueInEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Integer max = Integer.MIN_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                max = Math.max(max,node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(max);
        }
        return res;
    }

}