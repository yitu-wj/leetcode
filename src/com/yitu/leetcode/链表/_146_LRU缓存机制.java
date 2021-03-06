package com.yitu.leetcode.链表;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 */
public class _146_LRU缓存机制 {
    private Map<Integer,Node> map;
    private int capacity;
    // 虚拟头节点
    private Node first;
    // 虚拟尾节点
    private Node last;

    public _146_LRU缓存机制(int capacity) {
        map=new HashMap<>(capacity);
        this.capacity=capacity;
        first=new Node();
        last=new Node();
        first.next=last;
        last.prev=first;
    }

    public int get(int key) {
        Node node=map.get(key);
        if(node==null) return -1;

        removeNode(node);
        addAfterFirst(node);

        return node.value;
    }

    public void put(int key, int value) {
        Node node=map.get(key);
        if(node!=null){
            node.value=value;
            removeNode(node);
        }else { // 添加一对新的key-value
            if(map.size()==capacity){
                // 淘汰最近最少使用的node
                removeNode(map.remove(last.prev.key));
            }
            map.put(key,node=new Node(key,value));
        }
        addAfterFirst(node);
    }

    /**
     * 将node节点插入到first节点的后面
     */
    private void addAfterFirst(Node node){
        // node与first.next
        node.next=first.next;
        first.next.prev=node;
        // node与first
        first.next=node;
        node.prev=first;
    }

    /**
     * 从双向链表中删除node节点
     */
    private void removeNode(Node node){
        node.next.prev=node.prev;
        node.prev.next=node.next;
    }

    private static class Node{
        public int key;
        public int value;
        public Node prev;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }
}
