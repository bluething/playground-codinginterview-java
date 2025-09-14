package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _104_MaximumDepthOfBinaryTreeTest extends _01_ParentTreeTest {
    @Test
    void case01() {
        // Input: root = [3,9,20,null,null,15,7]
        // Output: 3
        // The maximum depth is 3 (root -> 20 -> 15 or root -> 20 -> 7)
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );

        int expected = 3;
        int result = maxDepth(root);
        assertEquals(expected, result);
    }

    @Test
    void case02() {
        // Input: root = [1,null,2]
        // Output: 2
        // The maximum depth is 2 (root -> 2)
        TreeNode root = new TreeNode(1,
                null,
                new TreeNode(2)
        );

        int expected = 2;
        int result = maxDepth(root);
        assertEquals(expected, result);
    }

    private int maxDepth(TreeNode root) {
        return 0;
    }
}
