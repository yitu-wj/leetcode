package com.yitu.leetcode.二叉树;


import com.yitu.leetcode.TreeNode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class _144_二叉树的前序遍历 {
    /**
     * 递归方式实现前序遍历
     */
    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder1(list, root);
        return list;
    }

    private static void preorder1(List<Integer> list, TreeNode node) {
        if (node == null) return;
        list.add(node.val);
        preorder1(list, node.left);
        preorder1(list, node.right);
    }

    /**
     * 循环方式实现前序遍历，用栈模拟方法的调用
     */
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2, null, null)), null);
        List<Integer> list1 = preorderTraversal1(root);
        System.out.println(list1);
        List<Integer> list2 = preorderTraversal2(root);
        System.out.println(list2);
    }
}
