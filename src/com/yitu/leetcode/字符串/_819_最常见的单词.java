package com.yitu.leetcode.字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/most-common-word/
 */
public class _819_最常见的单词 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = getWordCount(paragraph);
        for (String s : banned) {
            map.remove(s);
        }
        String maxKey = "";
        Integer maxValue = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value > maxValue) {
                maxKey = key;
                maxValue = value;
            }
        }
        return maxKey;
    }

    public Map<String, Integer> getWordCount(String paragraph) {
        Map<String, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int length = paragraph.length();
        while (end < length) {
            char endChar = paragraph.charAt(end);
            if (Character.isLetter(endChar)) end++;
            else { // 不是字母
                String substring = paragraph.substring(start, end).toLowerCase();
                int count = map.getOrDefault(substring, 0);
                map.put(substring, ++count);
                while (end < length && !Character.isLetter(paragraph.charAt(end))) {
                    end++;
                }
                start = end;
            }
        }
        if (start != end) {
            String substring = paragraph.substring(start, end).toLowerCase();
            int count = map.getOrDefault(substring, 0);
            map.put(substring, ++count);
        }
        return map;
    }

    public static void main(String[] args) {
//        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String paragraph = "Bob";
        Map<String, Integer> map = new _819_最常见的单词().getWordCount(paragraph);
        System.out.println(map);
    }
}
