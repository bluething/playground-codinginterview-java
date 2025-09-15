package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Stack;

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

    @Test
    void case03() {
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
        int result = maxDepth2(root);
        assertEquals(expected, result);
    }

    @Test
    void case04() {
        // Input: root = [1,null,2]
        // Output: 2
        // The maximum depth is 2 (root -> 2)
        TreeNode root = new TreeNode(1,
                null,
                new TreeNode(2)
        );

        int expected = 2;
        int result = maxDepth2(root);
        assertEquals(expected, result);
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    private int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int max = 0;
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        Stack<Integer> counters = new Stack<>();
        counters.push(1);
        int counter = 0;
        
        while (!nodes.isEmpty()) {
            TreeNode current = nodes.pop();
            counter = counters.pop();
            max = Math.max(max, counter);

            if (current.left != null) {
                nodes.push(current.left);
                counters.push(counter + 1);
            }
            if (current.right != null) {
                nodes.push(current.right);
                counters.push(counter + 1);
            }
        }

        return max;
    }
}
