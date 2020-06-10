package com.chaka.algorithms.recursion;

import com.chaka.algorithms.tree.node.TreeNode;

/**
 * <a href="https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/">二叉树的最近公共祖先</a>
 *  是公共祖先的情况
 *      1、p和q在root子树中，且在root的两侧
 *      2、p == root，q在root的左子树或右子树
 *      3、q == root，p在root的左子树或右子树
 *  1、递归
 *      1、终止条件
 *          当叶节点为空时，直接返回null
 *          当节点 == p 或 节点 == q时，直接返回节点值
 *      2、递推工作
 *
 *      3、返回值
 */
public class LowestCommonAncestorOfABinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if (root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null){
            return right;
        }
        if (right == null){
            return left;
        }
        return root;
    }

}
