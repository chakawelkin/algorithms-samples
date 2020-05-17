package com.chaka.algorithms.tree;

import com.chaka.algorithms.tree.node.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode-cn.com/problems/binary-tree-inorder-traversal/">二叉树的中序遍历</a>
 *  1、递归
 *  {@code
 *      public void traverse(TreeNode node,List<Integer> list){
 *         if (node.left != null){
 *             traverse(node.left,list);
 *         }
 *         list.add(node.val);
 *         if (node.right != null){
 *             traverse(node.right,list);
 *         }
 *     }
 *  }
 *  2、栈
 *  {@code
 *      public List<Integer> inorderTraversal(TreeNode root) {
 *         List<Integer> list = new ArrayList<>();
 *         Stack<TreeNode> stack = new Stack<>();
 *         TreeNode curr = root;
 *         while (curr != null || !stack.isEmpty()){
 *             while (curr != null){
 *                 stack.push(curr);
 *                 curr = curr.left;
 *             }
 *             curr = stack.pop();
 *             list.add(curr.val);
 *             curr = curr.right;
 *         }
 *         return list;
 *     }
 *  }
 *
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null){
                res.add(cur.val);
                cur = cur.right;
            }else {
                TreeNode tmp = cur.left;
                while (tmp.right != null && tmp.right != cur){
                    tmp = tmp.right;
                }
                if(tmp.right == null){
                    tmp.right = cur;
                    cur = cur.left;
                }else {
                    res.add(cur.val);
                    tmp.right = null;
                    cur = cur.right;
                }
            }

        }
        return res;
    }



}
