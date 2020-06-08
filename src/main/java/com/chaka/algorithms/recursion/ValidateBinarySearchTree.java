package com.chaka.algorithms.recursion;

import com.chaka.algorithms.tree.node.TreeNode;

/**
 * <a href="https://leetcode-cn.com/problems/validate-binary-search-tree/">验证二叉搜索树</a>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 *  1、递归
 *      对于每一个节点，确定好它的边界值（测试用例真的很牛X,会卡边界值，所以这里就用LONG.MAX做边界值）
 *  2、中序遍历后验证是否有序
 *      BST的特点就是，中序遍历后的元素是顺序性的
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        return reverse(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean reverse(TreeNode node, Long minVal, Long maxVal) {
        if (node == null) {
            return true;
        }
        if (node.val <= minVal || node.val >= maxVal) {
            return false;
        }
        return reverse(node.left, minVal, (long)node.val) && reverse(node.right, (long)node.val, maxVal);
    }

}