package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class _108_ConvertSortedArraytoBinarySearchTreeTest extends _01_ParentTreeTest {
    @Test
    void case01() {
        // Input: nums = [-10,-3,0,5,9]
        // Expected output: [0,-3,9,-10,null,5] (one possible valid BST)
        int[] nums = {-10, -3, 0, 5, 9};

        TreeNode result = sortedArrayToBST(nums);
        assertNotNull(result);

        // Check if it's a valid BST
        assertTrue(isValidBST(result, null, null));

        // Check if it's height-balanced
        assertTrue(getHeight(result) != -1);

        // The root should be the middle element (0)
        assertEquals(0, result.value);
    }

    @Test
    void case02() {
        // Input: nums = [1,3]
        // Expected output: [3,1] (one possible valid BST)
        int[] nums = {1, 3};

        TreeNode result = sortedArrayToBST(nums);
        assertNotNull(result);

        // Check if it's a valid BST
        assertTrue(isValidBST(result, null, null));

        // Check if it's height-balanced
        assertTrue(getHeight(result) != -1);

        // For array [1,3], root could be either 1 or 3 depending on implementation
        assertTrue(result.value == 1 || result.value == 3);
    }

    @Test
    void case03() {
        // Single element array
        int[] nums = {5};

        TreeNode result = sortedArrayToBST(nums);
        assertNotNull(result);
        assertEquals(5, result.value);
        assertNull(result.left);
        assertNull(result.right);

        assertTrue(isValidBST(result, null, null));
        assertTrue(getHeight(result) != -1);
    }

    void case04() {
        // Empty array
        int[] nums = {};

        TreeNode result = sortedArrayToBST(nums);
        assertNull(result);
    }

    @Test
    void case05() {
        // Larger array with odd number of elements
        int[] nums = {1, 2, 3, 4, 5, 6, 7};

        TreeNode result = sortedArrayToBST(nums);
        assertNotNull(result);

        // Check if it's a valid BST
        assertTrue(isValidBST(result, null, null));

        // Check if it's height-balanced
        assertTrue(getHeight(result) != -1);

        // Root should be middle element (4)
        assertEquals(4, result.value);
    }

    @Test
    void case06() {
        // Array with even number of elements
        int[] nums = {1, 2, 3, 4, 5, 6};

        TreeNode result = sortedArrayToBST(nums);
        assertNotNull(result);

        // Check if it's a valid BST
        assertTrue(isValidBST(result, null, null));

        // Check if it's height-balanced
        assertTrue(getHeight(result) != -1);

        // For even number of elements, root could be either middle element
        // depending on whether we choose left or right middle
        assertTrue(result.value == 3 || result.value == 4);
    }

    @Test
    void case07() {
        // Array with negative numbers
        int[] nums = {-5, -3, -1, 0, 2, 4, 6};

        TreeNode result = sortedArrayToBST(nums);
        assertNotNull(result);

        // Check if it's a valid BST
        assertTrue(isValidBST(result, null, null));

        // Check if it's height-balanced
        assertTrue(getHeight(result) != -1);

        // Root should be middle element (0)
        assertEquals(0, result.value);
    }

    @Test
    void case08() {
        // Two elements
        int[] nums = {1, 2};

        TreeNode result = sortedArrayToBST(nums);
        assertNotNull(result);

        // Check if it's a valid BST
        assertTrue(isValidBST(result, null, null));

        // Check if it's height-balanced
        assertTrue(getHeight(result) != -1);

        // Root could be either 1 or 2
        assertTrue(result.value == 1 || result.value == 2);
    }
    private TreeNode sortedArrayToBST(int[] nums) {
        return null;
    }
}
