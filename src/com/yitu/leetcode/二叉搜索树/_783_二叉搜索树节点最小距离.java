package com.yitu.leetcode.二叉搜索树;

import com.yitu.leetcode.TreeNode;

/**
 * https://leetcode.cn/problems/minimum-distance-between-bst-nodes/
 */
public class _783_二叉搜索树节点最小距离 {
    int pre;
    int ans;

    public int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre != -1) {
            ans = Math.min(ans, Math.abs(root.val - pre));
        }
        pre = root.val;
        dfs(root.right);
    }
}
