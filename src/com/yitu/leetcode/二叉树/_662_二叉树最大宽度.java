package com.yitu.leetcode.二叉树;

import com.yitu.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
 */
public class _662_二叉树最大宽度 {
    /**
     * 简单结构的二叉树可以计算，复杂的会导致超时
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> leveList = new LinkedList<>();
        queue.offer(root);
        int leveSize = 1;
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            leveList.add(node);
            leveSize--;
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            } else {
                queue.add(null);
                queue.add(null);
            }
            if (leveSize == 0) {
                leveSize = queue.size();
                int newWidth = widthOfBinaryTreeLevel(leveList);
                if (newWidth == 0) break;
                maxWidth = Math.max(maxWidth, newWidth);
                leveList.clear();
            }
        }
        return maxWidth;
    }

    /**
     * 第一思路：广度优先遍历，思路可行，开搞
     * 搞完一波发现思路好像不太行，因为它中间空的位置也要计算
     * 看了看评论发现一个很吊的思路：因为每个节点原本的值是没有用处的，所以我们可以用其来保存节点的位置信息
     * 所用的算法知识点（完全二叉树的性质）：对于一颗完全二插树，如果按照从上至下，从左往右对所有节点从零开始顺序编号
     * 则父节点的左孩子节点的序号：2*i+1   父节点的左孩子节点的序号：2*i+2;
     * 所以每层的宽度就可以使用：每层最后一个节点的值减去最后一个节点的值+1
     */
    public int widthOfBinaryTree2(TreeNode root) {
        // 避免异常的产生
        if (root == null) {
            return 0;
        }
        // 创建一个队列来进行广度优先遍历,注意这个地方就不要使用Queue<TreeNode> queue=new LinkedList<TreeNode>();
        // 因为父类不能调用子类的方法：getLast getFirst
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 创建一个变量来保存最大宽度
        int maxWidth = 0;
        // 将根节点入队列
        queue.offer(root);
        // 改变根结点的值
        root.val = 0;
        while (!queue.isEmpty()) {
            // 记录当前队列中的个数
            int count = queue.size();
            //创建一个变量来计算每层的宽度
            int newWidth = queue.getLast().val - queue.getFirst().val + 1;
            for (int i = 0; i < count; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                    temp.left.val = temp.val * 2 + 1;
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                    temp.right.val = temp.val * 2 + 2;
                }
            }
            // 求出每一层的宽度
            // 通过比较找除最大宽度
            if (newWidth > maxWidth) {
                maxWidth = newWidth;
            }
        }
        return maxWidth;
    }

    public int widthOfBinaryTreeLevel(List<TreeNode> leve) {
        int left = 0;
        int right = leve.size() - 1;
        TreeNode leftNode = leve.get(left);
        TreeNode rightNode = leve.get(right);
        while (leftNode == null || rightNode == null) {
            if (left > right) return 0;
            if (leftNode == null) left++;
            if (rightNode == null) right--;
            leftNode = leve.get(left);
            rightNode = leve.get(right);
        }
        return right - left + 1;
    }

    public static void main(String[] args) {
        List<TreeNode> leve = new LinkedList<>();
        leve.add(null);
        leve.add(null);
        leve.add(null);
//        leve.add(new TreeNode(0));
//        leve.add(new TreeNode(0));
//        leve.add(new TreeNode(0));
//        leve.add(new TreeNode(0));
        leve.add(null);
        leve.add(null);
//        leve.add(new TreeNode(0));
        leve.add(null);
        leve.add(null);
        int result = new _662_二叉树最大宽度().widthOfBinaryTreeLevel(leve);
        System.out.println(result);
    }
}
