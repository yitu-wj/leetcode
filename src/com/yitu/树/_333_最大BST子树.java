package com.yitu.树;

import com.yitu.TreeNode;

/**
 * https://leetcode-cn.com/problems/largest-bst-subtree/
 */
public class _333_最大BST子树 {
    public int largestBSTSubtree(TreeNode root) {
        return (root == null) ? 0 : getInfo(root).size;
    }

    private Info getInfo(TreeNode root) {
        if (root == null) return null;
        // li(left info):左子树的最大BST子树信息
        Info li = getInfo(root.left);
        // ri(right info):右子树的最大BST子树信息
        Info ri = getInfo(root.right);
        /**
         * 有四种情况，以root为根节点的二叉树就是一颗BST，最大BST子树就是本身
         * 1⃣️ li != null && ri != null
         * && li.root == root.left && root.val > li.max
         * && li.root == root.right && root.val < ri.min
         *
         * 2⃣️ li !=null && ri == null
         * && li.root == root.left && root.val > li.max
         *
         * 3⃣️ li == null && ri != null
         * && ri.root == root.right && root.val < ri.min
         *
         * 4⃣️ li == null && ri == null
         */
        int leftBstSize = -1, rightBstSize = -1, max = root.val, min = root.val;
        if (li == null) {
            leftBstSize = 0;
        } else if (li.root == root.left && root.val > li.max) {
            leftBstSize = li.size;
            min = li.min;
        }

        if (ri == null) {
            rightBstSize = 0;
        } else if (ri.root == root.right && root.val < ri.min) {
            rightBstSize = ri.size;
            max = ri.max;
        }

        if (leftBstSize >= 0 && rightBstSize >= 0) {
            return new Info(root, 1 + leftBstSize + rightBstSize, max, min);
        }
        // 返回最大BST子树的节点数量较多的那个Info
        if (li != null && ri != null) return (li.size > ri.size) ? li : ri;
        // 返回li,ri中不为null的那个Info
        return (li != null) ? li : ri;
    }

    /**
     * 最大的BST子树的信息
     */
    private static class Info {
        // 根节点
        public TreeNode root;
        // 节点总数
        public int size;
        // 最大值
        public int max;
        // 最小值
        public int min;

        public Info(TreeNode root, int size, int max, int min) {
            this.root = root;
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }
}
