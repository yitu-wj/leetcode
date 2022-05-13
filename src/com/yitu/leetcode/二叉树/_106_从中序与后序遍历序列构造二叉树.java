package com.yitu.leetcode.二叉树;

import com.yitu.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class _106_从中序与后序遍历序列构造二叉树 {
    int[] inorder;
    int[] postorder;
    int postIndex;
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        this.postIndex = postorder.length - 1;

        int index = 0;
        for (int i : inorder) {
            inorderMap.put(i, index++);
        }
        return helper(0, inorder.length - 1);
    }

    public TreeNode helper(int left, int right) {
        if (left > right) return null;
        int rootValue = postorder[postIndex];
        postIndex--;
        TreeNode root = new TreeNode(rootValue);
        Integer index = inorderMap.get(rootValue);
        root.right = helper(index + 1, right);
        root.left = helper(left, index - 1);
        return root;
    }
}
