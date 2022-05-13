package com.yitu.leetcode.二叉树;

import com.yitu.leetcode.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 */
public class _429_N叉树的层序遍历 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize = 1;
        List<Integer> levelList = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            levelList.add(node.val);
            levelSize--;
            queue.addAll(node.children);
            if (levelSize == 0) {
                result.add(levelList);
                levelList = new ArrayList<>();
                levelSize = queue.size();
            }
        }
        return result;
    }
}
