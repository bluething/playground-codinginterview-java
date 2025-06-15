package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class _704_binarySearchTest {
    @Test
    void case01() {
        Assertions.assertEquals(4, search(new int[]{-1,0,3,5,9,12}, 9));
    }

    @Test
    void case02() {
        Assertions.assertEquals(-1, search(new int[]{-1,0,3,5,9,12}, 2));
    }

    private int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
