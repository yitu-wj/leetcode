package com.yitu.leetcode.树;

import com.yitu.leetcode.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 */
public class _107_二叉树的层序遍历II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        List<Integer> levelList = new LinkedList<>();
        queue.offer(root);
        int levelSize = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            levelList.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            levelSize--;
            if (levelSize == 0) {
                levelSize = queue.size();
                result.add(levelList);
                levelList = new LinkedList<>();
            }
        }
        Collections.reverse(result);
        return result;
    }
}
