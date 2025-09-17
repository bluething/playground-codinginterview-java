package io.github.bluething.playground.codinginterview.java.leetcode;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _671_SecondMinimumNodeInaBinaryTreeTest {

    @Test
    void case01() {
        // Input: root = [2,2,5,null,null,5,7]
        // Tree structure:
        //     2
        //   /   \
        //  2     5
        //       / \
        //      5   7
        // Values: [2,2,5,5,7] -> Unique values: [2,5,7] -> Second minimum: 5
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        int expected = 5;
        int result = findSecondMinimumValue(root);
        assertEquals(expected, result);
    }

    @Test
    void case02() {
        // Input: root = [2,2,2]
        // Tree structure:
        //   2
        //  / \
        // 2   2
        // Values: [2,2,2] -> Unique values: [2] -> No second minimum: -1
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        int expected = -1;
        int result = findSecondMinimumValue(root);
        assertEquals(expected, result);
    }

    @Test
    void case03() {
        // Single node tree
        TreeNode root = new TreeNode(5);

        int expected = -1;
        int result = findSecondMinimumValue(root);
        assertEquals(expected, result);
    }

    @Test
    void case04() {
        // Two different values
        //  1
        // / \
        //1   3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        int expected = 3;
        int result = findSecondMinimumValue(root);
        assertEquals(expected, result);
    }

    @Test
    void case05() {
        // Tree with multiple unique values
        //     1
        //   /   \
        //  1     3
        // / \   / \
        //1   1 3   4
        // Values: [1,1,3,1,1,3,4] -> Unique values: [1,3,4] -> Second minimum: 3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        int expected = 3;
        int result = findSecondMinimumValue(root);
        assertEquals(expected, result);
    }

    @Test
    void case06() {
        // Left-skewed tree with increasing values
        //   1
        //  /
        // 2
        ///
        //3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        int expected = 2;
        int result = findSecondMinimumValue(root);
        assertEquals(expected, result);
    }

    @Test
    void case07() {
        // Right-skewed tree with increasing values
        // 1
        //  \
        //   2
        //    \
        //     3
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        int expected = 2;
        int result = findSecondMinimumValue(root);
        assertEquals(expected, result);
    }

    @Test
    void case08() {
        // Tree where minimum appears multiple times, second minimum once
        //     1
        //   /   \
        //  1     2
        // / \
        //1   1
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);

        int expected = 2;
        int result = findSecondMinimumValue(root);
        assertEquals(expected, result);
    }

    @Test
    void case09() {
        // Two nodes with same value
        //  3
        // /
        //3
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(3);

        int expected = -1;
        int result = findSecondMinimumValue(root);
        assertEquals(expected, result);
    }

    @Test
    void case10() {
        // Two nodes with different values
        //  5
        //   \
        //    7
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(7);

        int expected = 7;
        int result = findSecondMinimumValue(root);
        assertEquals(expected, result);
    }

    @Test
    void case11() {
        // Complex tree with many duplicates
        //       2
        //     /   \
        //    2     5
        //   / \   / \
        //  2   2 5   6
        //           / \
        //          6   7
        // Values: [2,2,5,2,2,5,6,6,7] -> Unique values: [2,5,6,7] -> Second minimum: 5
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        int expected = 5;
        int result = findSecondMinimumValue(root);
        assertEquals(expected, result);
    }

    @Test
    void case12() {
        // Tree with larger numbers
        //     10
        //   /    \
        //  10    15
        // / \   / \
        //10 10 15 20
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(10);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(10);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(20);

        int expected = 15;
        int result = findSecondMinimumValue(root);
        assertEquals(expected, result);
    }

    @Test
    void case13() {
        // Tree following the special property where each node has exactly 0 or 2 children
        // and each node's value is the minimum of its subtree
        //     1
        //   /   \
        //  1     3
        //       / \
        //      3   3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(3);

        int expected = 3;
        int result = findSecondMinimumValue(root);
        assertEquals(expected, result);
    }

    @Test
    void case14() {
        // Edge case: all nodes have same value in a larger tree
        //     5
        //   /   \
        //  5     5
        // / \   / \
        //5   5 5   5
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(5);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(5);

        int expected = -1;
        int result = findSecondMinimumValue(root);
        assertEquals(expected, result);
    }

    private int secondMinimumValue = Integer.MAX_VALUE;
    private int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int minValue = root.value;
        dfs(root, minValue);

        return secondMinimumValue == Integer.MAX_VALUE ? -1 : secondMinimumValue;
    }
    private void dfs(TreeNode node, int minValue) {
        if (node == null) {
            return;
        }

        // If we found a value greater than min but less than current secondMin
        if (node.value > minValue && node.value < secondMinimumValue) {
            secondMinimumValue = node.value;
        }

        dfs(node.left, minValue);
        dfs(node.right, minValue);
    }
}
