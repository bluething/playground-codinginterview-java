package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class _238_productOfArrayExceptSelfTest {
    @Test
    void case01() {
        Assertions.assertArrayEquals(new int[]{24,12,8,6}, productExceptSelf(new int[]{1,2,3,4}));
    }

    @Test
    void case02() {
        Assertions.assertArrayEquals(new int[]{0,0,9,0,0}, productExceptSelf(new int[]{-1,1,0,-3,3}));
    }

    private int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }
        int postfix = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }
        return result;
    }
}
