package com.chaka.algorithms.recursion;

import com.chaka.algorithms.tree.node.TreeNode;

/**
 * <a href="https://leetcode-cn.com/problems/invert-binary-tree/">翻转二叉树</a>
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }
        reverse(root);
        return root;
    }

    public void reverse(TreeNode node){
        TreeNode tmp = node.right;
        node.right = node.left;
        node.left = tmp;

        if (node.left != null) {
            reverse(node.left);
        }
        if (node.right != null) {
            reverse(node.right);
        }
    }

}
