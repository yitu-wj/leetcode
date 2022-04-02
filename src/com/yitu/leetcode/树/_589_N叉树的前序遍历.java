package com.yitu.leetcode.树;

import com.yitu.leetcode.Node;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 */
public class _589_N叉树的前序遍历 {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new LinkedList<>();
        preorder(root, list);
        return list;
    }

    public void preorder(Node root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        for (Node child : root.children) {
            preorder(child,list);
        }
    }
}
