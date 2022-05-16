package com.yitu.leetcode.二叉搜索树;

import com.yitu.leetcode.TreeNode;

/**
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 */
public class _99_恢复二叉搜索树 {
    /**
     * 第一个错误节点
     */
    private TreeNode first;
    /**
     * 第二个错误节点
     */
    private TreeNode second;
    private TreeNode prev;

    public void recoverTree(TreeNode root) {
        findWrongNodes(root);
        int tmp=first.val;
        first.val= second.val;
        second.val=tmp;
    }

    public void find(TreeNode node) {
        // 出现了逆序对
        if (prev != null && prev.val > node.val) {
            // 第2个错误节点：最后一个逆序对中较小的那个节点
            second=node;
            if(first!=null) return;;
            // 第1个错误节点：第一个逆序对中较大的那个节点
            first=prev;
        }
        prev=node;
    }

    public void findWrongNodes(TreeNode node) {
        if (node == null) return;
        findWrongNodes(node.left);
        find(node);
        findWrongNodes(node.right);
    }
}
