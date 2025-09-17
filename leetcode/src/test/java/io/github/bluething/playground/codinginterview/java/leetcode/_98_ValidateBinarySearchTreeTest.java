package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class _98_ValidateBinarySearchTreeTest {

    @Test
    void case01() {
        // Input: root = [2,1,3]
        // Tree structure:
        //   2
        //  / \
        // 1   3
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        boolean result = isValidBST(root);
        assertTrue(result);
    }

    @Test
    void case02() {
        // Input: root = [5,1,4,null,null,3,6]
        // Tree structure:
        //     5
        //    / \
        //   1   4
        //      / \
        //     3   6
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        boolean result = isValidBST(root);
        assertFalse(result);
    }

    @Test
    void case03() {
        // Single node tree
        TreeNode root = new TreeNode(1);

        boolean result = isValidBST(root);
        assertTrue(result);
    }

    @Test
    void case04() {
        // Empty tree
        TreeNode root = null;

        boolean result = isValidBST(root);
        assertTrue(result);
    }

    @Test
    void case05() {
        // Left-skewed valid BST
        //   3
        //  /
        // 2
        ///
        //1
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);

        boolean result = isValidBST(root);
        assertTrue(result);
    }

    @Test
    void case06() {
        // Right-skewed valid BST
        // 1
        //  \
        //   2
        //    \
        //     3
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        boolean result = isValidBST(root);
        assertTrue(result);
    }

    @Test
    void case07() {
        // Invalid BST - duplicate values
        //   2
        //  / \
        // 2   3
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        boolean result = isValidBST(root);
        assertFalse(result);
    }

    @Test
    void case08() {
        // Invalid BST - violates BST property at deeper level
        //     10
        //    /  \
        //   5   15
        //      /  \
        //     6   20
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);

        boolean result = isValidBST(root);
        assertFalse(result);
    }

    private boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean dfs(TreeNode node, long minVal, long maxVal) {
        if (node == null) {
            return true;
        }

        if (node.value <= minVal || node.value >= maxVal) {
            return false;
        }

        return dfs(node.left, minVal, node.value) && dfs(node.right, node.value, maxVal);
    }
}
