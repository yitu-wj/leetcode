package com.yitu.leetcode.二叉搜索树;

import com.yitu.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
 */
public class _230_二叉搜索树中第K小的元素 {
    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        return list.get(k - 1).val;
    }

    private void dfs(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        dfs(root.left, list);
        list.add(root);
        dfs(root.right, list);
    }
}
