package com.yitu.leetcode.二叉树;

import com.yitu.leetcode.TreeNode;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */
public class _114_二叉树展开为链表 {
    TreeNode listTailNode;

    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode headNode = new TreeNode();
        listTailNode = headNode;
        flatten2(root);
        root.left = null;
        root.right = headNode.right.right;
    }

    public void flatten2(TreeNode root) {
        if (root == null) return;
        TreeNode newNode = new TreeNode(root.val);
        listTailNode.right = newNode;
        listTailNode = newNode;
        flatten2(root.left);
        flatten2(root.right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(2), new TreeNode(5));
        new _114_二叉树展开为链表().flatten(node);
        System.out.println(node);

    }
}
