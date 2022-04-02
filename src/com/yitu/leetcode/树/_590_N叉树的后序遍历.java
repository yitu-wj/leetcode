package com.yitu.leetcode.树;

import com.yitu.leetcode.Node;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class _590_N叉树的后序遍历 {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new LinkedList<>();
        postorder(root, list);
        return list;
    }

    public void postorder(Node root, List<Integer> list) {
        if (root == null) return;
        for (Node child : root.children) {
            postorder(child, list);
        }
        list.add(root.val);
    }
}
