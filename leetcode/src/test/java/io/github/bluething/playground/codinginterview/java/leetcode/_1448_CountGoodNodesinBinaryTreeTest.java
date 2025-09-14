package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _1448_CountGoodNodesinBinaryTreeTest {
    @Test
    void case01() {
        // Input: root = [3,1,4,3,null,1,5]
        // Output: 4
        // Good nodes: 3 (root), 4 (4 >= 3), 3 (3 >= 3), 5 (5 >= 4)
        TreeNode root = new TreeNode(3,
                new TreeNode(1,
                        new TreeNode(3),
                        null
                ),
                new TreeNode(4,
                        new TreeNode(1),
                        new TreeNode(5)
                )
        );

        int expected = 4;
        int result = goodNodes(root);
        assertEquals(expected, result);
    }

    @Test
    void case02() {
        // Input: root = [3,3,null,4,2]
        // Output: 3
        // Good nodes: 3 (root), 3 (3 >= 3), 4 (4 >= 3)
        // Node 2 is not good because 2 < 3
        TreeNode root = new TreeNode(3,
                new TreeNode(3,
                        new TreeNode(4),
                        new TreeNode(2)
                ),
                null
        );

        int expected = 3;
        int result = goodNodes(root);
        assertEquals(expected, result);
    }

    @Test
    void case03() {
        // Input: root = [1]
        // Output: 1
        // Single node case - root is always good
        TreeNode root = new TreeNode(1);

        int expected = 1;
        int result = goodNodes(root);
        assertEquals(expected, result);
    }

    private int goodNodes(TreeNode root) {
        return 0;
    }
}
