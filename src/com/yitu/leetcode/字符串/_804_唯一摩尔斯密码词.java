package com.yitu.leetcode.字符串;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/unique-morse-code-words/
 */
public class _804_唯一摩尔斯密码词 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] table = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder str = new StringBuilder();
            for (char c : word.toCharArray()) {
                str.append(table[c - 'a']);
            }
            set.add(str.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        String[] words = new String[]{"gin", "zen", "gig", "msg"};
        int i = new _804_唯一摩尔斯密码词().uniqueMorseRepresentations(words);
        System.out.println(i);
    }
}
