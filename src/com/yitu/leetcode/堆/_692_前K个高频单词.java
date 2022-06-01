package com.yitu.leetcode.堆;

import java.util.*;

/**
 * https://leetcode.cn/problems/top-k-frequent-words/
 */
public class _692_前K个高频单词 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<Word> sortList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sortList.add(new Word(entry.getKey(), entry.getValue()));
        }

        sortList.sort((o1, o2) -> {
            if (o1.count == o2.count) {
                return o1.word.compareTo(o2.word);
            }
            return o2.count - o1.count;
        });
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(sortList.get(i).word);
        }
        return result;
    }

    static class Word {
        String word;
        int count;

        public Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        String[] words=new String[]{"i","love","leetcode","i","love","coding"};
        List<String> list = new _692_前K个高频单词().topKFrequent(words, 1);
        System.out.println(list);
    }
}
