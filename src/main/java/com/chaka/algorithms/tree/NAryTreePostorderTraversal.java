package com.chaka.algorithms.tree;

import com.chaka.algorithms.tree.node.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * N叉树的后序遍历
 * 1、递归
 * {@code
 *  public List<Integer> postorder(Node root) {
 *         List<Integer> list = new ArrayList<>();
 *         traversal(root,list);
 *         return list;
 *     }
 *
 *     public void traversal(Node node, List<Integer> list){
 *         if (node == null){
 *             return;
 *         }
 *         if (node.children != null && !node.children.isEmpty()){
 *             for (Node child : node.children) {
 *                 traversal(child,list);
 *             }
 *         }
 *
 *         list.add(node.val);
 *     }
 * }
 * 2、迭代
 */
public class NAryTreePostorderTraversal {

    public List<Integer> postorder(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null){
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            list.addFirst(node.val);
            for (Node child : node.children) {
                if (child != null){
                    stack.add(child);
                }
            }
        }
        return list;
    }

}