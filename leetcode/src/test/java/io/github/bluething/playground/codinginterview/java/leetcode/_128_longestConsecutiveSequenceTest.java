package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class _128_longestConsecutiveSequenceTest {
    @Test
    void case01() {
        Assertions.assertEquals(4, longestConsecutive(new int[]{100,4,200,1,3,2}));
    }

    @Test
    void case02() {
        Assertions.assertEquals(9, longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }

    @Test
    void case03() {
        Assertions.assertEquals(3, longestConsecutive(new int[]{1,0,-1}));
    }
    private int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 1;
        int longest = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if(nums[i] == nums[i - 1] + 1) {
                    count++;
                } else {
                    longest = Math.max(longest, count);
                    count = 1;
                }
            }
        }
        return Math.max(longest, count);
    }
}
