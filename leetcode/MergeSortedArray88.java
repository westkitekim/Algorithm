package leetcode;
/**
 * LeetCode
 * 88. Merge Sorted Array
 *
 * 정렬된 배열 2개를 병합하여 재정렬
 * 배열 크기는 변경불가에 유의  -> ArrayList 사용
 */

import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[i - m];
        }

        //정렬
        Arrays.sort(nums1);
    }
}