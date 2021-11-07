package com.yitu.链表;

import com.yitu.ListNode;

/**
 * https://leetcode-cn.com/problems/partition-list/
 */
public class _86_分隔链表 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode lHead = new ListNode(0);
        ListNode lTail = lHead;
        ListNode rHead = new ListNode(0);
        ListNode rTail = rHead;
        while (head != null) {
            if (head.val < x) { // 放在lTail后面
                lTail.next = head;
                lTail = head;
            } else { // 放在rTail后面
                rTail.next = head;
                rTail = head;
            }
            head = head.next;
        }
        rTail.next = null;
        // 将rHead.next拼接在lTail后面
        lTail.next = rHead.next;
        return lHead.next;
    }
}
