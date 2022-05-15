package com.yitu.leetcode.二叉搜索树;

import com.yitu.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-search-tree-iterator/
 */
public class _173_二叉搜索树迭代器 {
    static class BSTIterator {
        private List<TreeNode> list = new ArrayList<>();
        private int index = 0;

        public BSTIterator(TreeNode root) {
            dfs(root, list);
        }

        public int next() {
            int index= Math.min(this.index, list.size() - 1);
            int val=list.get(index).val;
            this.index++;
            return val;
        }

        public boolean hasNext() {
            return index<=list.size()-1;
        }

        private void dfs(TreeNode root, List<TreeNode> list) {
            if (root == null) return;
            dfs(root.left, list);
            list.add(root);
            dfs(root.right, list);
        }
    }
    /**
     * Your BSTIterator object will be instantiated and called as such:
     * BSTIterator obj = new BSTIterator(root);
     * int param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */
    public static void main(String[] args) {
        TreeNode left=new TreeNode(3);
        TreeNode right=new TreeNode(15,new TreeNode(9),new TreeNode(20));
        TreeNode root = new TreeNode(7, left, right);
        BSTIterator bstIterator = new BSTIterator(root);
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
    }
}
