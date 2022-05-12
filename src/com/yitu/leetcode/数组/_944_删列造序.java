package com.yitu.leetcode.数组;

/**
 * https://leetcode.cn/problems/delete-columns-to-make-sorted/
 */
public class _944_删列造序 {
    public int minDeletionSize(String[] strs) {
        int deleteSize = 0;
        int row = strs.length;
        int col = strs[0].length();
        char[][] chars = new char[row][];
        for (int i = 0; i < strs.length; i++) {
            chars[i] = strs[i].toCharArray();
        }
        if (row <= 1) return deleteSize;
        for (int colIndex = 0; colIndex < col; colIndex++) {
            for (int rowIndex = 1; rowIndex < row; rowIndex++) {
                if (chars[rowIndex][colIndex] < chars[rowIndex - 1][colIndex]) {
                    deleteSize++;
                    break;
                }
            }
        }
        return deleteSize;
    }

    public static void main(String[] args) {
//        String[] strs = new String[]{"rrjk", "furt", "guzm"};
        String[] strs = new String[]{
                "dsadasdhdhasdhksajdhkajshdkjashdkjas",
                "dafsdlasdlsahdklasjdlksajdlkasjdlkns",
                "gskdhkjshfewhfkjshfkjshfkjsdhfjksahhi",
                "hlskadlksabfutyabsdlsakjsdalksadiasdl"};
        int deletionSize = new _944_删列造序().minDeletionSize(strs);
        System.out.println(deletionSize);
    }
}
