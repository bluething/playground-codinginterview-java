package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class _103_BinaryTreeZigzagLevelOrderTraversalTest {
    @Test
    void case01() {
        // Input: root = [3,9,20,null,null,15,7]
        // Tree structure:
        //     3           -> Level 0: [3] (left to right)
        //   /   \
        //  9    20        -> Level 1: [20,9] (right to left)
        //      /  \
        //     15   7      -> Level 2: [15,7] (left to right)
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(3),
                Arrays.asList(20, 9),
                Arrays.asList(15, 7)
        );

        List<List<Integer>> result = zigzagLevelOrder(root);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case02() {
        // Input: root = [1]
        // Single node tree
        TreeNode root = new TreeNode(1);

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1)
        );

        List<List<Integer>> result = zigzagLevelOrder(root);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case03() {
        // Input: root = []
        // Empty tree
        TreeNode root = null;

        List<List<Integer>> expected = Collections.emptyList();

        List<List<Integer>> result = zigzagLevelOrder(root);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case04() {
        // Complete balanced binary tree
        //     1           -> Level 0: [1] (left to right)
        //   /   \
        //  2     3        -> Level 1: [3,2] (right to left)
        // / \   / \
        //4   5 6   7     -> Level 2: [4,5,6,7] (left to right)
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(3, 2),
                Arrays.asList(4, 5, 6, 7)
        );

        List<List<Integer>> result = zigzagLevelOrder(root);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case05() {
        // Left-skewed tree
        //   1             -> Level 0: [1] (left to right)
        //  /
        // 2              -> Level 1: [2] (right to left)
        ///
        //3               -> Level 2: [3] (left to right)
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3)
        );

        List<List<Integer>> result = zigzagLevelOrder(root);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case06() {
        // Right-skewed tree
        // 1              -> Level 0: [1] (left to right)
        //  \
        //   2            -> Level 1: [2] (right to left)
        //    \
        //     3          -> Level 2: [3] (left to right)
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3)
        );

        List<List<Integer>> result = zigzagLevelOrder(root);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case07() {
        // Five-level tree to test multiple zigzag patterns
        //         1       -> Level 0: [1] (left to right)
        //       /   \
        //      2     3    -> Level 1: [3,2] (right to left)
        //     / \   / \
        //    4   5 6   7  -> Level 2: [4,5,6,7] (left to right)
        //   /
        //  8             -> Level 3: [8] (right to left)
        //   \
        //    9           -> Level 4: [9] (left to right)
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.left.right = new TreeNode(9);

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(3, 2),
                Arrays.asList(4, 5, 6, 7),
                Arrays.asList(8),
                Arrays.asList(9)
        );

        List<List<Integer>> result = zigzagLevelOrder(root);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case08() {
        // Tree with negative values
        //    -1           -> Level 0: [-1] (left to right)
        //   /  \
        // -2    3        -> Level 1: [3,-2] (right to left)
        //      /
        //    -4          -> Level 2: [-4] (left to right)
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(-4);

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(-1),
                Arrays.asList(3, -2),
                Arrays.asList(-4)
        );

        List<List<Integer>> result = zigzagLevelOrder(root);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case09() {
        // Two nodes (left child)
        //  1              -> Level 0: [1] (left to right)
        // /
        //2               -> Level 1: [2] (right to left)
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2)
        );

        List<List<Integer>> result = zigzagLevelOrder(root);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case10() {
        // Two nodes (right child)
        // 1              -> Level 0: [1] (left to right)
        //  \
        //   2            -> Level 1: [2] (right to left)
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2)
        );

        List<List<Integer>> result = zigzagLevelOrder(root);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case11() {
        // Asymmetric tree with different level sizes
        //       1         -> Level 0: [1] (left to right)
        //     /   \
        //    2     3      -> Level 1: [3,2] (right to left)
        //   / \     \
        //  4   5     6    -> Level 2: [4,5,6] (left to right)
        // /
        //7             -> Level 3: [7] (right to left)
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(3, 2),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7)
        );

        List<List<Integer>> result = zigzagLevelOrder(root);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case12() {
        // Four-level tree with more complex zigzag
        //       1         -> Level 0: [1] (left to right)
        //     /   \
        //    2     3      -> Level 1: [3,2] (right to left)
        //   /     / \
        //  4     5   6    -> Level 2: [4,5,6] (left to right)
        //         \   \
        //          7   8 -> Level 3: [8,7] (right to left)
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(3, 2),
                Arrays.asList(4, 5, 6),
                Arrays.asList(8, 7)
        );

        List<List<Integer>> result = zigzagLevelOrder(root);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    private List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return Collections.emptyList();
    }
}
