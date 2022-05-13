package com.yitu.leetcode.二叉树;

import com.yitu.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class _105_从前序与中序遍历序列构造二叉树 {
    int[] inorder;
    int[] preorder;
    int postIndex;
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder = inorder;
        this.preorder = preorder;
        this.postIndex = 0;

        int index = 0;
        for (int i : inorder) {
            inorderMap.put(i, index++);
        }
        return helper(0, inorder.length - 1);
    }

    public TreeNode helper(int left, int right) {
        if (left > right) return null;
        int rootValue = preorder[postIndex];
        postIndex++;
        TreeNode root = new TreeNode(rootValue);
        Integer index = inorderMap.get(rootValue);
        root.left = helper(left, index - 1);
        root.right = helper(index + 1, right);
        return root;
    }
}
