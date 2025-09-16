package io.github.bluething.playground.codinginterview.java.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class _107_BinaryTreeLevelOrderTraversalIITest {
    @Test
    void case01() {
        // Input: root = [3,9,20,null,null,15,7]
        // Tree structure:
        //     3
        //   /   \
        //  9    20
        //      /  \
        //     15   7
        // Level order from bottom: [[15,7],[9,20],[3]]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(15, 7),
                Arrays.asList(9, 20),
                Arrays.asList(3)
        );

        List<List<Integer>> result = levelOrderBottom(root);
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

        List<List<Integer>> result = levelOrderBottom(root);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case03() {
        // Input: root = []
        // Empty tree
        TreeNode root = null;

        List<List<Integer>> expected = Collections.emptyList();

        List<List<Integer>> result = levelOrderBottom(root);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case04() {
        // Complete balanced binary tree
        //     1
        //   /   \
        //  2     3
        // / \   / \
        //4   5 6   7
        // Level order from bottom: [[4,5,6,7],[2,3],[1]]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(4, 5, 6, 7),
                Arrays.asList(2, 3),
                Arrays.asList(1)
        );

        List<List<Integer>> result = levelOrderBottom(root);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case05() {
        // Left-skewed tree
        //   1
        //  /
        // 2
        ///
        //3
        // Level order from bottom: [[3],[2],[1]]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(3),
                Arrays.asList(2),
                Arrays.asList(1)
        );

        List<List<Integer>> result = levelOrderBottom(root);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case06() {
        // Right-skewed tree
        // 1
        //  \
        //   2
        //    \
        //     3
        // Level order from bottom: [[3],[2],[1]]
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(3),
                Arrays.asList(2),
                Arrays.asList(1)
        );

        List<List<Integer>> result = levelOrderBottom(root);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case07() {
        // Asymmetric tree with different level depths
        //       1
        //     /   \
        //    2     3
        //   /       \
        //  4         5
        // /           \
        //6             7
        // Level order from bottom: [[6,7],[4,5],[2,3],[1]]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(6, 7),
                Arrays.asList(4, 5),
                Arrays.asList(2, 3),
                Arrays.asList(1)
        );

        List<List<Integer>> result = levelOrderBottom(root);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case08() {
        // Two-level tree with only left child
        //  1
        // /
        //2
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(1)
        );

        List<List<Integer>> result = levelOrderBottom(root);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case09() {
        // Two-level tree with only right child
        // 1
        //  \
        //   2
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(1)
        );

        List<List<Integer>> result = levelOrderBottom(root);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case10() {
        // Tree with negative values
        //    -1
        //   /  \
        // -2    3
        //      /
        //    -4
        // Level order from bottom: [[-4],[-2,3],[-1]]
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(-4);

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(-4),
                Arrays.asList(-2, 3),
                Arrays.asList(-1)
        );

        List<List<Integer>> result = levelOrderBottom(root);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case11() {
        // Incomplete tree with missing nodes at different levels
        //     1
        //   /   \
        //  2     3
        // /     / \
        //4     5   6
        // Level order from bottom: [[4,5,6],[2,3],[1]]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(4, 5, 6),
                Arrays.asList(2, 3),
                Arrays.asList(1)
        );

        List<List<Integer>> result = levelOrderBottom(root);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    private List<List<Integer>> levelOrderBottom(TreeNode root) {
        return Collections.emptyList();
    }
}
