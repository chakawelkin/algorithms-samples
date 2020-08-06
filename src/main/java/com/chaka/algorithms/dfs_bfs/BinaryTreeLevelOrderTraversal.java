package com.chaka.algorithms.dfs_bfs;

import com.chaka.algorithms.tree.node.TreeNode;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode-cn.com/problems/binary-tree-level-order-traversal/">二叉树的层序遍历</a>
 *  1、递归
 *  2、队列BFS
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
        return null;
    }

}
