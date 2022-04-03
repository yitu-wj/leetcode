package com.yitu.leetcode.数组;

/**
 * https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
 */
public class _744_寻找比目标字母大的最小字母 {
    public char nextGreatestLetter(char[] letters, char target) {
        while (true) {
            target++;
            if (target > 'z') target = 'a';
            for (char letter : letters) {
                if (letter == target) return letter;
            }
        }
    }

    public static void main(String[] args) {
        char[] letters = new char[]{'c', 'f','j'};
        char result = new _744_寻找比目标字母大的最小字母().nextGreatestLetter(letters, 'd');
        System.out.println(result);
    }
}
