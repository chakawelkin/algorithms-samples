package com.chaka.algorithms.tree;

import com.chaka.algorithms.tree.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历
 * 1、递归
 * 2、迭代 （栈）
 * 3、莫里斯遍历
 */
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null){
            if (cur.left == null){
                list.add(cur.val);
                cur = cur.right;
            }else {
                TreeNode tmp = cur.left;
                while (tmp.right != null && tmp.right != cur){
                    tmp = tmp.right;
                }
                if (tmp.right == null){
                    tmp.right = cur;
                    list.add(cur.val);
                    cur = cur.left;
                }else {
                    tmp.right = null;
                    cur = cur.right;
                }
            }
        }
        return list;
    }

}