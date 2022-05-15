package com.yitu.leetcode.二叉搜索树;

import com.yitu.leetcode.TreeNode;

/**
 * https://leetcode.cn/problems/range-sum-of-bst/
 */
public class _938_二叉搜索树的范围和 {
    int ret = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return ret;
        int val = root.val;
        if (val >= low && val <= high) ret += val;
        rangeSumBST(root.left, low, high);
        rangeSumBST(root.right, low, high);
        return ret;
    }

}
