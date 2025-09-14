package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _110_BalancedBinaryTreeTest extends _01_ParentTreeTest {
    @Test
    void case01() {
        // Input: root = [3,9,20,null,null,15,7]
        // Output: true
        // The tree is height-balanced
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );

        boolean expected = true;
        boolean result = isBalanced(root);
        assertEquals(expected, result);
    }

    @Test
    void case02() {
        // Input: root = []
        // Output: true
        // An empty tree is considered balanced
        TreeNode root = null;

        boolean expected = true;
        boolean result = isBalanced(root);
        assertEquals(expected, result);
    }

    private boolean isBalanced(TreeNode root) {
        return false;
    }
}
