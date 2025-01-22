package com.chaka.algorithms.tree;

import com.chaka.algorithms.tree.node.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * N叉树的前序遍历
 */
public class NAryTreePreorderTraversal {

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            list.add(node.val);
            Collections.reverse(node.children);
            for (Node child : node.children) {
                if (child != null){
                    stack.add(child);
                }
            }
        }
        return list;
    }

}
