package com.yitu.leetcode.字符串;


/**
 * https://leetcode-cn.com/problems/goat-latin/
 */
public class _824_山羊拉丁文 {
    public String toGoatLatin(String sentence) {
        String[] strings = sentence.split(" ");
        String[] resultStrings = new String[strings.length];
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            char c = string.toLowerCase().charAt(0);
            if (!(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')) { // 元音开头
                String firstLetter = string.substring(0, 1);
                string = string.substring(1) + firstLetter;
            }
            string += "ma";
            for (int j = 0; j <= i; j++) {
                string += "a";
            }
            resultStrings[i] = string;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < resultStrings.length; i++) {
            stringBuilder.append(resultStrings[i]);
            if(i<resultStrings.length-1){
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String str = "I speak Goat Latin";
        String result = new _824_山羊拉丁文().toGoatLatin(str);
        System.out.println(result);
    }
}
