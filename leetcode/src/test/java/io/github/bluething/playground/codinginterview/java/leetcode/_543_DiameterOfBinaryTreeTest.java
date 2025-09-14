package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _543_DiameterOfBinaryTreeTest extends _01_ParentTreeTest {

    @Test
    void case01() {
        // Input: root = [1,2,3,4,5]
        // Output: 3
        // The diameter is the path [4,2,1,3] or [5,2,1,3] with length 3
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)
                ),
                new TreeNode(3)
        );

        int expected = 3;
        int result = diameterOfBinaryTree(root);
        assertEquals(expected, result);
    }

    @Test
    void case02() {
        // Input: root = [1,2]
        // Output: 1
        // The diameter is the path [2,1] with length 1
        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                null
        );

        int expected = 1;
        int result = diameterOfBinaryTree(root);
        assertEquals(expected, result);
    }

    private int diameterOfBinaryTree(TreeNode root) {
        return 0;
    }
}
