package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _643_MaximumAverageSubarrayITest {
    @Test
    void case01() {
        // Input: nums = [1,12,-5,-6,50,3], k = 4
        // Subarrays of length 4:
        // [1,12,-5,-6] = 2, average = 0.5
        // [12,-5,-6,50] = 51, average = 12.75
        // [-5,-6,50,3] = 42, average = 10.5
        // Maximum average: 12.75
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        double expected = 12.75000;
        double result = findMaxAverage(nums, k);
        assertDoubleEquals(expected, result);
    }

    @Test
    void case02() {
        // Input: nums = [5], k = 1
        // Only one subarray: [5], average = 5.0
        int[] nums = {5};
        int k = 1;
        double expected = 5.00000;
        double result = findMaxAverage(nums, k);
        assertDoubleEquals(expected, result);
    }

    @Test
    void case03() {
        // Array length equals k
        int[] nums = {1, 2, 3, 4};
        int k = 4;
        double expected = 2.5; // (1+2+3+4)/4 = 10/4 = 2.5
        double result = findMaxAverage(nums, k);
        assertDoubleEquals(expected, result);
    }

    @Test
    void case04() {
        // k = 1, find maximum single element
        int[] nums = {-1, -2, -3, 5, -4};
        int k = 1;
        double expected = 5.0;
        double result = findMaxAverage(nums, k);
        assertDoubleEquals(expected, result);
    }

    @Test
    void case05() {
        // All positive numbers
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;
        // Subarrays: [1,2,3]=6/3=2, [2,3,4]=9/3=3, [3,4,5]=12/3=4
        double expected = 4.0;
        double result = findMaxAverage(nums, k);
        assertDoubleEquals(expected, result);
    }

    @Test
    void case06() {
        // All negative numbers
        int[] nums = {-1, -2, -3, -4, -5};
        int k = 2;
        // Subarrays: [-1,-2]=-3/2=-1.5, [-2,-3]=-5/2=-2.5,
        // [-3,-4]=-7/2=-3.5, [-4,-5]=-9/2=-4.5
        // Maximum: -1.5
        double expected = -1.5;
        double result = findMaxAverage(nums, k);
        assertDoubleEquals(expected, result);
    }

    @Test
    void case07() {
        // Two elements, k = 1
        int[] nums = {3, 7};
        int k = 1;
        double expected = 7.0;
        double result = findMaxAverage(nums, k);
        assertDoubleEquals(expected, result);
    }

    @Test
    void case08() {
        // Two elements, k = 2
        int[] nums = {3, 7};
        int k = 2;
        double expected = 5.0; // (3+7)/2 = 5.0
        double result = findMaxAverage(nums, k);
        assertDoubleEquals(expected, result);
    }

    @Test
    void case09() {
        // Maximum at the beginning
        int[] nums = {8, 6, 1, 2, 3};
        int k = 2;
        // Subarrays: [8,6]=14/2=7, [6,1]=7/2=3.5, [1,2]=3/2=1.5, [2,3]=5/2=2.5
        double expected = 7.0;
        double result = findMaxAverage(nums, k);
        assertDoubleEquals(expected, result);
    }

    @Test
    void case10() {
        // Maximum at the end
        int[] nums = {1, 2, 3, 8, 9};
        int k = 2;
        // Subarrays: [1,2]=3/2=1.5, [2,3]=5/2=2.5, [3,8]=11/2=5.5, [8,9]=17/2=8.5
        double expected = 8.5;
        double result = findMaxAverage(nums, k);
        assertDoubleEquals(expected, result);
    }

    @Test
    void case11() {
        // Array with zeros
        int[] nums = {0, 1, 1, 3, 3};
        int k = 4;
        // Subarrays: [0,1,1,3]=5/4=1.25, [1,1,3,3]=8/4=2.0
        double expected = 2.0;
        double result = findMaxAverage(nums, k);
        assertDoubleEquals(expected, result);
    }

    @Test
    void case12() {
        // Mixed positive and negative with zero
        int[] nums = {-1, 0, 1, 2, -1};
        int k = 3;
        // Subarrays: [-1,0,1]=0/3=0, [0,1,2]=3/3=1, [1,2,-1]=2/3≈0.667
        double expected = 1.0;
        double result = findMaxAverage(nums, k);
        assertDoubleEquals(expected, result);
    }

    @Test
    void case13() {
        // Large k (most of array)
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 5;
        // Subarrays: [1,2,3,4,5]=15/5=3, [2,3,4,5,6]=20/5=4
        double expected = 4.0;
        double result = findMaxAverage(nums, k);
        assertDoubleEquals(expected, result);
    }

    @Test
    void case14() {
        // Identical consecutive elements
        int[] nums = {5, 5, 5, 5};
        int k = 2;
        // All subarrays have same average: 5.0
        double expected = 5.0;
        double result = findMaxAverage(nums, k);
        assertDoubleEquals(expected, result);
    }

    @Test
    void case15() {
        // Single negative number
        int[] nums = {-10};
        int k = 1;
        double expected = -10.0;
        double result = findMaxAverage(nums, k);
        assertDoubleEquals(expected, result);
    }

    @Test
    void case16() {
        // Large positive and negative numbers
        int[] nums = {1000, -1000, 500, 2000};
        int k = 2;
        // Subarrays: [1000,-1000]=0/2=0, [-1000,500]=-500/2=-250, [500,2000]=2500/2=1250
        double expected = 1250.0;
        double result = findMaxAverage(nums, k);
        assertDoubleEquals(expected, result);
    }

    @Test
    void case17() {
        // Alternating positive and negative
        int[] nums = {1, -1, 2, -2, 3, -3};
        int k = 3;
        // Subarrays: [1,-1,2]=2/3≈0.667, [-1,2,-2]=-1/3≈-0.333,
        // [2,-2,3]=3/3=1, [-2,3,-3]=-2/3≈-0.667
        double expected = 1.0;
        double result = findMaxAverage(nums, k);
        assertDoubleEquals(expected, result);
    }

    @Test
    void case18() {
        // Decimal result test
        int[] nums = {1, 3, 2};
        int k = 2;
        // Subarrays: [1,3]=4/2=2, [3,2]=5/2=2.5
        double expected = 2.5;
        double result = findMaxAverage(nums, k);
        assertDoubleEquals(expected, result);
    }

    @Test
    void case19() {
        // Edge case: very large numbers to test integer overflow
        int[] nums = {2147483647, 2147483646, 2147483645};
        int k = 2;
        // Need to handle potential integer overflow when summing
        double expected = (2147483647.0 + 2147483646.0) / 2;
        double result = findMaxAverage(nums, k);
        assertDoubleEquals(expected, result);
    }

    @Test
    void case20() {
        // Complex case with various patterns
        int[] nums = {10, -5, 8, -3, 6, 20, -10, 15};
        int k = 3;
        // Test sliding window efficiency
        // Subarrays: [10,-5,8]=13/3≈4.333, [-5,8,-3]=0/3=0, [8,-3,6]=11/3≈3.667
        // [−3,6,20]=23/3≈7.667, [6,20,-10]=16/3≈5.333, [20,-10,15]=25/3≈8.333
        double expected = 25.0 / 3.0;
        double result = findMaxAverage(nums, k);
        assertDoubleEquals(expected, result);
    }

    // Helper method to compare double values with tolerance
    private void assertDoubleEquals(double expected, double actual) {
        assertEquals(expected, actual, 0.00001,
                "Expected " + expected + " but got " + actual);
    }

    private double findMaxAverage(int[] nums, int k) {
        return 0.0;
    }
}
