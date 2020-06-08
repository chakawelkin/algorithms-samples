package com.chaka.algorithms.recursion;

import com.chaka.algorithms.tree.node.TreeNode;

/**
 * <a href="https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/">二叉树的最大深度</a>
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode node) {
        if (node == null){
            return 0;
        }
        int leftHight = maxDepth(node.left);
        int rightHight = maxDepth(node.right);
        return Math.max(leftHight,rightHight) + 1;
    }

}