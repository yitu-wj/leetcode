package com.yitu.leetcode.二叉树;

import com.yitu.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/all-elements-in-two-binary-search-trees/
 */
public class _1305_两棵二叉搜索树中的所有元素 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> root1List = new ArrayList<>();
        List<Integer> root2List = new ArrayList<>();
        getElements(root1, root1List);
        getElements(root2, root2List);
        root1List.addAll(root2List);
        root1List.sort(Integer::compareTo);
        return root1List;
    }

    public void getElements(TreeNode root, List<Integer> list) {
        if (root == null) return;
        getElements(root.left, list);
        list.add(root.val);
        getElements(root.right, list);
    }
}
