package com.yitu.leetcode.二叉树;

import com.yitu.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class _101_对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> levelList = new LinkedList<>();
        queue.offer(root);
        int levelSize = 1;
        while (!queue.isEmpty()) {
            levelSize--;
            TreeNode node = queue.poll();
            levelList.add(node);
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
            if (levelSize == 0) {
                if (!isSymmetric(levelList)) return false;
                levelList.clear();
                levelSize = queue.size();
            }
        }
        return true;
    }

    public boolean isSymmetric(List<TreeNode> list) {
        if (list.size() <= 1) return true;
        for (int i = 0; i < list.size() / 2; i++) {
            TreeNode first = list.get(i);
            TreeNode second = list.get(list.size() - 1 - i);
            if (first == null && second == null) continue;
            if (first == null || second == null) return false;
            if (first.val != second.val) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(1);
        List<TreeNode> list = new LinkedList<>();
        list.add(node1);
        list.add(node2);
        list.add(null);
        list.add(null);
        list.add(node3);
        list.add(node4);
        boolean result = new _101_对称二叉树().isSymmetric(list);
        System.out.println(result);
    }
}
