package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class _153_findMinimuminRotatedSortedArrayTest {
    @Test
    void case01() {
        Assertions.assertEquals(1, findMin(new int[]{3,4,5,1,2}));
    }
    @Test
    void case02() {
        Assertions.assertEquals(0, findMin(new int[]{4,5,6,7,0,1,2}));
    }
    @Test
    void case03() {
        Assertions.assertEquals(11, findMin(new int[]{11,13,15,17}));
    }

    private int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
}
