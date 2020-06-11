package com.chaka.algorithms.recursion;

import com.chaka.algorithms.tree.node.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">从前序与中序遍历序列构造二叉树</a>
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    Map<Integer,Integer> idxMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        idxMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            idxMap.put(inorder[i],i);
        }
        return reBuildTree(preorder,0,preorder.length,inorder,0,inorder.length);
    }

    public TreeNode reBuildTree(int[] preorder, int preStart,int preEnd,int[] inorder,int inStart, int inEnd){
        if (preStart == preEnd){
            return null;
        }
        //构建当前节点
        TreeNode root = new TreeNode(preorder[preStart]);
        Integer rootIdx = idxMap.get(preorder[preStart]);
        int leftNum = rootIdx - inStart;//左子树的数量
        root.left = reBuildTree(preorder,preStart + 1,preStart + leftNum + 1,inorder,inStart,rootIdx);
        root.right = reBuildTree(preorder,preStart + leftNum + 1,preEnd,inorder,rootIdx + 1,inEnd);
        return root;
    }

}