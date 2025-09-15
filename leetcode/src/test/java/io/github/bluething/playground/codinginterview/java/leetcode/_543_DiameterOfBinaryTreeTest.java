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
        if (root == null) {
            return 0;
        }
        int[] diameter = new int[1];
        height(root, diameter);

        return diameter[0];
    }
    private int height(TreeNode root, int[] diameter) {
        if (root == null) {
            return -1;
        }

        int leftHeight = height(root.left, diameter);
        int rightHeight = height(root.right, diameter);

        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight + 2);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
