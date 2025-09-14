package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _100_SameTreeTest {
    @Test
    void case01() {
        // Input: p = [1,2,3], q = [1,2,3]
        // Output: true
        // Both trees have identical structure and values
        TreeNode p = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3)
        );

        TreeNode q = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3)
        );

        boolean expected = true;
        boolean result = isSameTree(p, q);
        assertEquals(expected, result);
    }

    @Test
    void case02() {
        // Input: p = [1,2], q = [1,null,2]
        // Output: false
        // Different structure: p has 2 as left child, q has 2 as right child
        TreeNode p = new TreeNode(1,
                new TreeNode(2),
                null
        );

        TreeNode q = new TreeNode(1,
                null,
                new TreeNode(2)
        );

        boolean expected = false;
        boolean result = isSameTree(p, q);
        assertEquals(expected, result);
    }

    @Test
    void case03() {
        // Input: p = [1,2,1], q = [1,1,2]
        // Output: false
        // Different values: p has [1,2,1], q has [1,1,2]
        TreeNode p = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(1)
        );

        TreeNode q = new TreeNode(1,
                new TreeNode(1),
                new TreeNode(2)
        );

        boolean expected = false;
        boolean result = isSameTree(p, q);
        assertEquals(expected, result);
    }

    private  boolean isSameTree(TreeNode p, TreeNode q) {
        return false;
    }
}
