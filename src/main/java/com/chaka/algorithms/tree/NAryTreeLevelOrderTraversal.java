package com.chaka.algorithms.tree;

import com.chaka.algorithms.tree.node.Node;

import java.util.*;

/**
 * N叉树的层序遍历
 *  1、利用队列实现广度优先搜索
 *      -- 添加下一层到队列的时候，将上一层的数据给处理掉
 *      {@code public List<List<Integer>> levelOrder(Node root) {
 *         List<List<Integer>> res = new ArrayList<>();
 *         if (root == null){
 *             return res;
 *         }
 *         Queue<Node> queue = new LinkedList<>();
 *         queue.add(root);
 *         while (!queue.isEmpty()){
 *             List<Integer> level = new ArrayList<>();
 *             int size = queue.size();
 *             for (int i = 0; i < size; i++) {
 *                 Node node = queue.poll();
 *                 level.add(node.val);
 *                 queue.addAll(node.children);//add the end
 *             }
 *             res.add(level);
 *         }
 *         return res;
 *     }}
 *  2、简化的广度优先搜索
 *      --
 *      {@code public List<List<Integer>> levelOrder(Node root) {
 *         List<List<Integer>> res = new ArrayList<>();
 *         if (root == null){
 *             return res;
 *         }
 *         List<Node> list = Arrays.asList(root);
 *         while (!list.isEmpty()){
 *             List<Integer> level = new ArrayList<>();
 *             List<Node> childList = new ArrayList<>();
 *             for (Node node : list) {
 *                 level.add(node.val);
 *                 if (node.children != null) {
 *                     childList.addAll(node.children);
 *                 }
 *             }
 *             list = childList;
 *             res.add(level);
 *         }
 *         return res;
 *     }}
 *  3、递归
 *     -- 遍历所有节点，保证对应的节点存储到对应的层即可（最优）
 */
public class NAryTreeLevelOrderTraversal {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null){
            return res;
        }
        traverse(root,0);
        return res;
    }

    public void traverse(Node node,int level){
        if (res.size() <= level){
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        for (Node child : node.children) {
            traverse(child,level + 1);
        }
    }

}