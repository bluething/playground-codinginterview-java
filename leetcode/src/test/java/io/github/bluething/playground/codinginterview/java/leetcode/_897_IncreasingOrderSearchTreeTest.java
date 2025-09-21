package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class _897_IncreasingOrderSearchTreeTest extends _01_ParentTreeTest {
    @Test
    void case01() {
        // Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
        // Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(8);
        root.left.left.left = new TreeNode(1);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);

        TreeNode result = increasingBST(root);

        // Verify result is right-skewed
        assertTrue(isRightSkewed(result));

        // Verify values are in correct order
        List<Integer> resultValues = getRightSkewedValues(result);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertEquals(expected, resultValues);

        // Verify structure (no left children)
        TreeNode current = result;
        for (int expectedValue : expected) {
            assertNotNull(current);
            assertEquals(expectedValue, current.value);
            assertNull(current.left);
            current = current.right;
        }
        assertNull(current);
    }

    @Test
    void case02() {
        // Input: root = [5,1,7]
        // Output: [1,null,5,null,7]

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);

        TreeNode result = increasingBST(root);

        assertTrue(isRightSkewed(result));

        List<Integer> resultValues = getRightSkewedValues(result);
        List<Integer> expected = Arrays.asList(1, 5, 7);
        assertEquals(expected, resultValues);

        // Verify specific structure
        assertEquals(1, result.value);
        assertNull(result.left);
        assertEquals(5, result.right.value);
        assertNull(result.right.left);
        assertEquals(7, result.right.right.value);
        assertNull(result.right.right.left);
        assertNull(result.right.right.right);
    }

    @Test
    void case03() {
        // Edge case: Single node
        TreeNode root = new TreeNode(5);

        TreeNode result = increasingBST(root);

        assertTrue(isRightSkewed(result));
        assertEquals(5, result.value);
        assertNull(result.left);
        assertNull(result.right);
    }

    @Test
    void case04() {
        // Edge case: Null root
        TreeNode root = null;

        TreeNode result = increasingBST(root);

        assertNull(result);
    }

    @Test
    void case05() {
        // Already right-skewed tree
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        TreeNode result = increasingBST(root);

        assertTrue(isRightSkewed(result));

        List<Integer> resultValues = getRightSkewedValues(result);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertEquals(expected, resultValues);
    }

    @Test
    void case06() {
        // Left-skewed tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);

        TreeNode result = increasingBST(root);

        assertTrue(isRightSkewed(result));

        List<Integer> resultValues = getRightSkewedValues(result);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertEquals(expected, resultValues);
    }

    @Test
    void case07() {
        // Balanced tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        TreeNode result = increasingBST(root);

        assertTrue(isRightSkewed(result));

        List<Integer> resultValues = getRightSkewedValues(result);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        assertEquals(expected, resultValues);
    }

    @Test
    void case08() {
        // Two nodes - left child
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);

        TreeNode result = increasingBST(root);

        assertTrue(isRightSkewed(result));

        List<Integer> resultValues = getRightSkewedValues(result);
        List<Integer> expected = Arrays.asList(1, 2);
        assertEquals(expected, resultValues);
    }

    @Test
    void case09() {
        // Two nodes - right child
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        TreeNode result = increasingBST(root);

        assertTrue(isRightSkewed(result));

        List<Integer> resultValues = getRightSkewedValues(result);
        List<Integer> expected = Arrays.asList(1, 2);
        assertEquals(expected, resultValues);
    }

    @Test
    void case10() {
        // Tree with negative values
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(-3);
        root.left.right = new TreeNode(-1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);

        TreeNode result = increasingBST(root);

        assertTrue(isRightSkewed(result));

        List<Integer> resultValues = getRightSkewedValues(result);
        List<Integer> expected = Arrays.asList(-3, -2, -1, 0, 1, 2, 3);
        assertEquals(expected, resultValues);
    }

    @Test
    void case11() {
        // Large tree with many levels
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(5);
        root.left.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(9);
        root.right.left.right = new TreeNode(11);
        root.right.right.left = new TreeNode(13);
        root.right.right.right = new TreeNode(15);

        TreeNode result = increasingBST(root);

        assertTrue(isRightSkewed(result));

        List<Integer> resultValues = getRightSkewedValues(result);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        assertEquals(expected, resultValues);
    }

    @Test
    void case12() {
        // Tree with duplicate values (if allowed)
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);

        TreeNode result = increasingBST(root);

        assertTrue(isRightSkewed(result));

        List<Integer> resultValues = getRightSkewedValues(result);
        List<Integer> expected = Arrays.asList(1, 2, 3, 3);
        assertEquals(expected, resultValues);
    }

    @Test
    void case13() {
        // Verify original tree properties are preserved in order
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        // Get original inorder for comparison
        List<Integer> originalInorder = getInorder(root);

        TreeNode result = increasingBST(root);

        // Verify result maintains same ordering
        List<Integer> resultValues = getRightSkewedValues(result);
        assertEquals(originalInorder, resultValues);

        // Verify result is valid BST (though right-skewed)
        assertTrue(isValidBST(result, null, null));

        // Verify result is right-skewed
        assertTrue(isRightSkewed(result));
    }

    @Test
    void case14() {
        // Test with large values
        TreeNode root = new TreeNode(1000);
        root.left = new TreeNode(500);
        root.right = new TreeNode(1500);
        root.left.left = new TreeNode(250);
        root.left.right = new TreeNode(750);

        TreeNode result = increasingBST(root);

        assertTrue(isRightSkewed(result));

        List<Integer> resultValues = getRightSkewedValues(result);
        List<Integer> expected = Arrays.asList(250, 500, 750, 1000, 1500);
        assertEquals(expected, resultValues);
    }

    // Helper method to verify the tree is right-skewed (only right children)
    private boolean isRightSkewed(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                return false;
            }
            root = root.right;
        }
        return true;
    }

    // Helper method to get values from right-skewed tree
    private List<Integer> getRightSkewedValues(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        while (root != null) {
            values.add(root.value);
            root = root.right;
        }
        return values;
    }

    TreeNode dummy;
    TreeNode current;
    private TreeNode increasingBST(TreeNode root) {
        dummy = new TreeNode(0);
        current = dummy;
        inOrder(root);
        return dummy.right;
    }
    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        node.left = null;
        current.right = node;
        current = node;
        inOrder(node.right);
    }
}
