package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class _226_InvertBinaryTreeTest extends _01_ParentTreeTest {
    @Test
    void case01() {
        // Input: root = [4,2,7,1,3,6,9]
        // Output: [4,7,2,9,6,3,1]
        TreeNode root = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)
                ),
                new TreeNode(7,
                        new TreeNode(6),
                        new TreeNode(9)
                )
        );

        TreeNode expected = new TreeNode(4,
                new TreeNode(7,
                        new TreeNode(9),
                        new TreeNode(6)
                ),
                new TreeNode(2,
                        new TreeNode(3),
                        new TreeNode(1)
                )
        );

        TreeNode result = invertTree(root);
        assertTrue(areTreesEqual(result, expected));
    }

    @Test
    void case02() {
        // Input: root = [2,1,3]
        // Output: [2,3,1]
        TreeNode root = new TreeNode(2,
                new TreeNode(1),
                new TreeNode(3)
        );

        TreeNode expected = new TreeNode(2,
                new TreeNode(3),
                new TreeNode(1)
        );

        TreeNode result = invertTree(root);
        assertTrue(areTreesEqual(result, expected));
    }

    @Test
    void case03() {
        // Input: root = []
        // Output: []

        TreeNode result = invertTree(null);
        assertTrue(areTreesEqual(result, null));
    }

    private TreeNode invertTree(TreeNode root) {
        return null;
    }
}