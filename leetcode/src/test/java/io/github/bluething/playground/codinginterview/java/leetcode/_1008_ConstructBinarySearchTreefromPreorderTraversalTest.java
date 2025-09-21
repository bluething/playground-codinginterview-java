package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class _1008_ConstructBinarySearchTreefromPreorderTraversalTest extends _01_ParentTreeTest {
    @Test
    void case01() {
        // Input: preorder = [8,5,1,7,10,12]
        // Expected BST structure:
        //       8
        //      / \
        //     5   10
        //    / \    \
        //   1   7    12

        int[] preorder = {8, 5, 1, 7, 10, 12};
        TreeNode result = bstFromPreorder(preorder);

        // Verify it's a valid BST
        assertTrue(isValidBST(result, null, null));

        // Verify preorder traversal matches input
        List<Integer> resultPreorder = getPreorder(result);
        List<Integer> expectedPreorder = Arrays.asList(8, 5, 1, 7, 10, 12);
        assertEquals(expectedPreorder, resultPreorder);

        // Verify specific structure
        assertEquals(8, result.value);
        assertEquals(5, result.left.value);
        assertEquals(10, result.right.value);
        assertEquals(1, result.left.left.value);
        assertEquals(7, result.left.right.value);
        assertNull(result.right.left);
        assertEquals(12, result.right.right.value);
    }

    @Test
    void case02() {
        // Input: preorder = [1,3]
        // Expected BST structure:
        //   1
        //    \
        //     3

        int[] preorder = {1, 3};
        TreeNode result = bstFromPreorder(preorder);

        assertTrue(isValidBST(result, null, null));

        List<Integer> resultPreorder = getPreorder(result);
        List<Integer> expectedPreorder = Arrays.asList(1, 3);
        assertEquals(expectedPreorder, resultPreorder);

        assertEquals(1, result.value);
        assertNull(result.left);
        assertEquals(3, result.right.value);
    }

    @Test
    void case03() {
        // Edge case: Single element
        int[] preorder = {5};
        TreeNode result = bstFromPreorder(preorder);

        assertTrue(isValidBST(result, null, null));

        assertEquals(5, result.value);
        assertNull(result.left);
        assertNull(result.right);

        List<Integer> resultPreorder = getPreorder(result);
        assertEquals(Arrays.asList(5), resultPreorder);
    }

    @Test
    void case04() {
        // Left-heavy tree: preorder = [10,5,3,7,6]
        int[] preorder = {10, 5, 3, 7, 6};
        TreeNode result = bstFromPreorder(preorder);

        assertTrue(isValidBST(result, null, null));

        List<Integer> resultPreorder = getPreorder(result);
        List<Integer> expectedPreorder = Arrays.asList(10, 5, 3, 7, 6);
        assertEquals(expectedPreorder, resultPreorder);

        assertEquals(10, result.value);
        assertEquals(5, result.left.value);
        assertEquals(3, result.left.left.value);
        assertEquals(7, result.left.right.value);
        assertEquals(6, result.left.right.left.value);
    }

    @Test
    void case05() {
        // Right-heavy tree: preorder = [3,7,5,10,12]
        int[] preorder = {3, 7, 5, 10, 12};
        TreeNode result = bstFromPreorder(preorder);

        assertTrue(isValidBST(result, null, null));

        List<Integer> resultPreorder = getPreorder(result);
        List<Integer> expectedPreorder = Arrays.asList(3, 7, 5, 10, 12);
        assertEquals(expectedPreorder, resultPreorder);

        assertEquals(3, result.value);
        assertNull(result.left);
        assertEquals(7, result.right.value);
        assertEquals(5, result.right.left.value);
        assertEquals(10, result.right.right.value);
        assertEquals(12, result.right.right.right.value);
    }

    @Test
    void case06() {
        // Descending order: preorder = [10,9,8,7,6]
        int[] preorder = {10, 9, 8, 7, 6};
        TreeNode result = bstFromPreorder(preorder);

        assertTrue(isValidBST(result, null, null));

        List<Integer> resultPreorder = getPreorder(result);
        List<Integer> expectedPreorder = Arrays.asList(10, 9, 8, 7, 6);
        assertEquals(expectedPreorder, resultPreorder);

        // Should create a left-skewed tree
        assertEquals(10, result.value);
        assertEquals(9, result.left.value);
        assertEquals(8, result.left.left.value);
        assertEquals(7, result.left.left.left.value);
        assertEquals(6, result.left.left.left.left.value);
    }

    @Test
    void case07() {
        // Ascending order: preorder = [1,2,3,4,5]
        int[] preorder = {1, 2, 3, 4, 5};
        TreeNode result = bstFromPreorder(preorder);

        assertTrue(isValidBST(result, null, null));

        List<Integer> resultPreorder = getPreorder(result);
        List<Integer> expectedPreorder = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(expectedPreorder, resultPreorder);

        // Should create a right-skewed tree
        assertEquals(1, result.value);
        assertEquals(2, result.right.value);
        assertEquals(3, result.right.right.value);
        assertEquals(4, result.right.right.right.value);
        assertEquals(5, result.right.right.right.right.value);
    }

    @Test
    void case08() {
        // Complex balanced tree: preorder = [50,25,15,35,75,65,85]
        int[] preorder = {50, 25, 15, 35, 75, 65, 85};
        TreeNode result = bstFromPreorder(preorder);

        assertTrue(isValidBST(result, null, null));

        List<Integer> resultPreorder = getPreorder(result);
        List<Integer> expectedPreorder = Arrays.asList(50, 25, 15, 35, 75, 65, 85);
        assertEquals(expectedPreorder, resultPreorder);

        // Verify structure
        assertEquals(50, result.value);
        assertEquals(25, result.left.value);
        assertEquals(75, result.right.value);
        assertEquals(15, result.left.left.value);
        assertEquals(35, result.left.right.value);
        assertEquals(65, result.right.left.value);
        assertEquals(85, result.right.right.value);
    }

    @Test
    void case09() {
        // Two elements - reverse order: preorder = [5,3]
        int[] preorder = {5, 3};
        TreeNode result = bstFromPreorder(preorder);

        assertTrue(isValidBST(result, null, null));

        List<Integer> resultPreorder = getPreorder(result);
        List<Integer> expectedPreorder = Arrays.asList(5, 3);
        assertEquals(expectedPreorder, resultPreorder);

        assertEquals(5, result.value);
        assertEquals(3, result.left.value);
        assertNull(result.right);
    }

    void case10() {
        // Large values: preorder = [1000,500,2000,250,750,1500,2500]
        int[] preorder = {1000, 500, 2000, 250, 750, 1500, 2500};
        TreeNode result = bstFromPreorder(preorder);

        assertTrue(isValidBST(result, null, null));

        List<Integer> resultPreorder = getPreorder(result);
        List<Integer> expectedPreorder = Arrays.asList(1000, 500, 2000, 250, 750, 1500, 2500);
        assertEquals(expectedPreorder, resultPreorder);

        assertEquals(1000, result.value);
        assertEquals(500, result.left.value);
        assertEquals(2000, result.right.value);
    }

    @Test
    void case11() {
        // Edge case: Empty array
        int[] preorder = {};
        TreeNode result = bstFromPreorder(preorder);
        assertNull(result);
    }

    @Test
    void case12() {
        // Edge case: Null array
        int[] preorder = null;
        TreeNode result = bstFromPreorder(preorder);
        assertNull(result);
    }

    @Test
    void case13() {
        // Verify inorder traversal is sorted (BST property)
        int[] preorder = {8, 5, 1, 7, 10, 12};
        TreeNode result = bstFromPreorder(preorder);

        List<Integer> inorderResult = getInorder(result);
        List<Integer> expectedInorder = Arrays.asList(1, 5, 7, 8, 10, 12);
        assertEquals(expectedInorder, inorderResult);
    }

    int idx = 0;
    private TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        idx = 0;
        return buildBST(Integer.MIN_VALUE, Integer.MAX_VALUE, preorder);
    }
    private TreeNode buildBST(int minVal, int maxVal, int[] preorder) {
        if (idx >= preorder.length) {
            return null;
        }

        int val = preorder[idx];
        if (val <= minVal || val >= maxVal) {
            return null;
        }
        idx++;
        TreeNode node = new TreeNode(val);

        node.left = buildBST(minVal, val, preorder);
        node.right = buildBST(val, maxVal, preorder);

        return node;
    }
}
