package com.chaka.algorithms.recursion;

import com.chaka.algorithms.tree.node.TreeNode;

/**
 * <a href="https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/">二叉树的最小深度</a>
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (root.left == null || root.right == null) ? left + right + 1 : Math.min(left,right) + 1;
    }

}