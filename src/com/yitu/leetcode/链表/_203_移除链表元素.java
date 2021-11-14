package com.yitu.leetcode.链表;

import com.yitu.leetcode.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class _203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        // 新链表的头节点
        ListNode newHead = new ListNode(0);
        // 新链表的尾结点
        ListNode newTail = newHead;
        while (head != null) {
            if (head.val != val) {
                newTail.next = head;
                newTail = head;
            }
            head = head.next;
        }
        newTail.next = null;
        return newHead.next;
    }
}
