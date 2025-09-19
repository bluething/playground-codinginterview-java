package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class _173_BinarySearchTreeIteratorTest extends _01_ParentTreeTest {
    @Test
    void case01() {
        // Example from problem description:
        // BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
        // Expected sequence: 3, 7, 9, 15, 20

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator iterator = new BSTIterator(root);

        // bSTIterator.next();    // return 3
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());

        // bSTIterator.next();    // return 7
        assertTrue(iterator.hasNext());
        assertEquals(7, iterator.next());

        // bSTIterator.hasNext(); // return True
        assertTrue(iterator.hasNext());

        // bSTIterator.next();    // return 9
        assertEquals(9, iterator.next());

        // bSTIterator.hasNext(); // return True
        assertTrue(iterator.hasNext());

        // bSTIterator.next();    // return 15
        assertEquals(15, iterator.next());

        // bSTIterator.hasNext(); // return True
        assertTrue(iterator.hasNext());

        // bSTIterator.next();    // return 20
        assertEquals(20, iterator.next());

        // bSTIterator.hasNext(); // return False
        assertFalse(iterator.hasNext());
    }

    @Test
    void case02() {
        // Single node tree
        TreeNode root = new TreeNode(5);

        BSTIterator iterator = new BSTIterator(root);

        assertTrue(iterator.hasNext());
        assertEquals(5, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void case03() {
        // Left-skewed tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(1);

        BSTIterator iterator = new BSTIterator(root);

        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(4, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(5, iterator.next());

        assertFalse(iterator.hasNext());
    }

    @Test
    void case04() {
        // Right-skewed tree
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(5);

        BSTIterator iterator = new BSTIterator(root);

        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(5, iterator.next());

        assertFalse(iterator.hasNext());
    }

    @Test
    void case05() {
        // Balanced binary search tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        BSTIterator iterator = new BSTIterator(root);

        List<Integer> result = new ArrayList<>();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }

        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        assertEquals(expected, result);
        assertFalse(iterator.hasNext());
    }

    @Test
    void case06() {
        // Tree with only left children from root
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(6);

        BSTIterator iterator = new BSTIterator(root);

        List<Integer> result = new ArrayList<>();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }

        List<Integer> expected = Arrays.asList(5, 6, 7, 10);
        assertEquals(expected, result);
    }

    @Test
    void case07() {
        // Tree with only right children from root
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(5);
        root.right.left.right = new TreeNode(7);

        BSTIterator iterator = new BSTIterator(root);

        List<Integer> result = new ArrayList<>();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }

        List<Integer> expected = Arrays.asList(3, 5, 7, 8);
        assertEquals(expected, result);
    }

    @Test
    void case08() {
        // Two-node tree - left child
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);

        BSTIterator iterator = new BSTIterator(root);

        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());

        assertFalse(iterator.hasNext());
    }

    @Test
    void case09() {
        // Two-node tree - right child
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        BSTIterator iterator = new BSTIterator(root);

        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());

        assertFalse(iterator.hasNext());
    }

    @Test
    void case10() {
        // Large tree to test memory efficiency
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(18);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(8);
        root.right.left.left = new TreeNode(11);
        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(16);
        root.right.right.right = new TreeNode(20);

        BSTIterator iterator = new BSTIterator(root);

        List<Integer> result = new ArrayList<>();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }

        List<Integer> expected = Arrays.asList(1, 2, 3, 5, 6, 7, 8, 10, 11, 12, 13, 15, 16, 18, 20);
        assertEquals(expected, result);
    }

    @Test
    void case11() {
        // Test with negative values
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(-5);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(-10);
        root.left.right = new TreeNode(-2);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(8);

        BSTIterator iterator = new BSTIterator(root);

        List<Integer> result = new ArrayList<>();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }

        List<Integer> expected = Arrays.asList(-10, -5, -2, 0, 2, 5, 8);
        assertEquals(expected, result);
    }

    @Test
    void case12() {
        // Test interleaved hasNext() and next() calls
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        BSTIterator iterator = new BSTIterator(root);

        // Multiple hasNext calls should not affect state
        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());

        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());
        assertEquals(4, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(5, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(8, iterator.next());

        assertFalse(iterator.hasNext());
        assertFalse(iterator.hasNext());
    }

    @Test
    void case13() {
        // Compare iterator output with inorder traversal
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        // Get expected inorder traversal
        List<Integer> expectedInorder = getInorder(root);

        // Get iterator output
        BSTIterator iterator = new BSTIterator(root);
        List<Integer> iteratorResult = new ArrayList<>();
        while (iterator.hasNext()) {
            iteratorResult.add(iterator.next());
        }

        // They should be identical
        assertEquals(expectedInorder, iteratorResult);
    }

    @Test
    void case14() {
        // Test that tree structure is a valid BST
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);

        // Verify input is valid BST
        assertTrue(isValidBST(root, null, null));

        BSTIterator iterator = new BSTIterator(root);

        List<Integer> result = new ArrayList<>();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }

        // Verify output is sorted (which it should be for valid BST)
        List<Integer> expected = Arrays.asList(5, 10, 15, 20, 25, 30, 35);
        assertEquals(expected, result);

        // Verify result is actually sorted
        for (int i = 1; i < result.size(); i++) {
            assertTrue(result.get(i-1) < result.get(i),
                    "Result should be sorted: " + result.get(i-1) + " >= " + result.get(i));
        }
    }

    class BSTIterator {

        public BSTIterator(TreeNode root) {

        }

        public int next() {
            return 0;
        }

        public boolean hasNext() {
            return false;
        }
    }
}
