package com.chaka.algorithms.recursion;

import com.chaka.algorithms.tree.node.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树的序列化与反序列化
 *  1、DFS 深度优先遍历
 */
public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return reSerialize(root,"");
    }

    public String reSerialize(TreeNode node,String str){
        if (node == null){
            str =  str + "null,";
        }else {
            //遍历顺序 root -> subleft -> rightleft
            str = str + node.val + ",";
            str = reSerialize(node.left,str);
            str = reSerialize(node.right,str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        Deque<String> queue = new LinkedList<>();
        for (String s : split) {
            queue.addLast(s);
        }
        return reDeserialize(queue);
    }

    public TreeNode reDeserialize(Deque<String> queue){
        if (queue.peek().equals("null")){
            queue.pop();
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(queue.pop()));
        root.left = reDeserialize(queue);
        root.right = reDeserialize(queue);

        return root;
    }

}