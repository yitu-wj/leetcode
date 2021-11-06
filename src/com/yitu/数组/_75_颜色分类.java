package com.yitu.数组;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 */
public class _75_颜色分类 {
    public void sortColors(int[] nums) {
        int i=0;
        int l=0;
        int r= nums.length-1;
        while (i<=r){
            if(nums[i]==0){
                swap(nums, i++, l++);
            }else if(nums[i]==1){
                i++;
            }else {
                swap(nums, i, r--);
            }
        }
    }
    private void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
