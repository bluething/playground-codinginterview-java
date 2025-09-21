package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _700_SearchinaBinarySearchTreeTest extends _01_ParentTreeTest {
    @Test
    void case01() {
        // Input: root = [4,2,7,1,3], val = 2
        // Output: [2,1,3]

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode result = searchBST(root, 2);

        assertNotNull(result);
        assertEquals(2, result.value);
        assertEquals(1, result.left.value);
        assertEquals(3, result.right.value);
        assertNull(result.left.left);
        assertNull(result.left.right);
        assertNull(result.right.left);
        assertNull(result.right.right);
    }

    @Test
    void case02() {
        // Input: root = [4,2,7,1,3], val = 5
        // Output: []

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode result = searchBST(root, 5);

        assertNull(result);
    }

    @Test
    void case03() {
        // Search for root node itself
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode result = searchBST(root, 4);

        assertNotNull(result);
        assertEquals(4, result.value);
        assertEquals(2, result.left.value);
        assertEquals(7, result.right.value);
        assertEquals(1, result.left.left.value);
        assertEquals(3, result.left.right.value);
    }

    @Test
    void case04() {
        // Search for leaf node
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode result = searchBST(root, 1);

        assertNotNull(result);
        assertEquals(1, result.value);
        assertNull(result.left);
        assertNull(result.right);
    }

    @Test
    void case05() {
        // Search for rightmost leaf
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode result = searchBST(root, 7);

        assertNotNull(result);
        assertEquals(7, result.value);
        assertNull(result.left);
        assertNull(result.right);
    }

    @Test
    void case06() {
        // Single node tree - value found
        TreeNode root = new TreeNode(5);

        TreeNode result = searchBST(root, 5);

        assertNotNull(result);
        assertEquals(5, result.value);
        assertNull(result.left);
        assertNull(result.right);
    }

    @Test
    void case07() {
        // Single node tree - value not found
        TreeNode root = new TreeNode(5);

        TreeNode result = searchBST(root, 3);

        assertNull(result);
    }

    @Test
    void case08() {
        // Empty tree
        TreeNode root = null;

        TreeNode result = searchBST(root, 5);

        assertNull(result);
    }

    @Test
    void case09() {
        // Left-skewed tree - search for leaf
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(6);
        root.left.left.left = new TreeNode(4);

        TreeNode result = searchBST(root, 4);

        assertNotNull(result);
        assertEquals(4, result.value);
        assertNull(result.left);
        assertNull(result.right);
    }

    @Test
    void case10() {
        // Right-skewed tree - search for intermediate node
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(7);

        TreeNode result = searchBST(root, 3);

        assertNotNull(result);
        assertEquals(3, result.value);
        assertNull(result.left);
        assertEquals(5, result.right.value);
        assertEquals(7, result.right.right.value);
    }

    @Test
    void case11() {
        // Search for value smaller than all nodes
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        TreeNode result = searchBST(root, 1);

        assertNull(result);
    }

    @Test
    void case12() {
        // Search for value larger than all nodes
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        TreeNode result = searchBST(root, 20);

        assertNull(result);
    }

    @Test
    void case13() {
        // Complex tree - search for node with both children
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);
        root.left.left.left = new TreeNode(10);
        root.left.right.right = new TreeNode(45);

        TreeNode result = searchBST(root, 30);

        assertNotNull(result);
        assertEquals(30, result.value);
        assertEquals(20, result.left.value);
        assertEquals(40, result.right.value);
        assertEquals(10, result.left.left.value);
        assertEquals(45, result.right.right.value);
    }

    @Test
    void case14() {
        // Test with negative values
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(-5);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(-10);
        root.left.right = new TreeNode(-2);

        TreeNode result = searchBST(root, -5);

        assertNotNull(result);
        assertEquals(-5, result.value);
        assertEquals(-10, result.left.value);
        assertEquals(-2, result.right.value);
    }

    @Test
    void case15() {
        // Test with large values
        TreeNode root = new TreeNode(1000);
        root.left = new TreeNode(500);
        root.right = new TreeNode(1500);
        root.left.left = new TreeNode(250);
        root.left.right = new TreeNode(750);

        TreeNode result = searchBST(root, 750);

        assertNotNull(result);
        assertEquals(750, result.value);
        assertNull(result.left);
        assertNull(result.right);
    }

    @Test
    void case16() {
        // Verify returned subtree maintains BST property
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        TreeNode result = searchBST(root, 3);

        assertNotNull(result);
        assertEquals(3, result.value);

        // Verify the returned subtree is a valid BST
        assertTrue(isValidBST(result, null, null));

        // Verify structure of returned subtree
        assertEquals(1, result.left.value);
        assertEquals(6, result.right.value);
        assertEquals(4, result.right.left.value);
        assertEquals(7, result.right.right.value);
    }

    private TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.value == val) {
            return root;
        }

        if (root.value > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
