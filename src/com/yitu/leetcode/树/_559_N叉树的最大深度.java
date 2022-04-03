package com.yitu.leetcode.树;

import com.yitu.leetcode.Node;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 */
public class _559_N叉树的最大深度 {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int maxDepth = 0;
        for (Node child : root.children) {
            maxDepth = Math.max(maxDepth, maxDepth(child));
        }
        return maxDepth + 1;
    }
}
