package com.yitu.leetcode.链表;

import com.yitu.leetcode.ListNode;

/**
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 */
public class _23_合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length <= 0) return null;
        ListNode listNode = lists[0];
        for (int i = 1; i < lists.length; i++) {
            listNode=mergeTwoLists(listNode, lists[i]);
        }
        return listNode;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode newNode;
        if (l1.val < l2.val) {
            newNode = l1;
            l1 = l1.next;
        } else {
            newNode = l2;
            l2 = l2.next;
        }
        ListNode lastNode = newNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                lastNode.next = l1;
                lastNode = l1;
                l1 = l1.next;
            } else {
                lastNode.next = l2;
                lastNode = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            lastNode.next = l1;
        }
        if (l2 != null) {
            lastNode.next = l2;
        }

        return newNode;
    }
}
